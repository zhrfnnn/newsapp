package app.zhrfnnn.newsapp.di.module

import app.zhrfnnn.newsapp.BuildConfig
import app.zhrfnnn.newsapp.data.remote.NewsService
import app.zhrfnnn.newsapp.data.repo.NewsRepo
import app.zhrfnnn.newsapp.data.repoimpl.NewsRepoImpl
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Zharfan on 7/16/2023.
 */

@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(logging: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor {
                val newRequest: Request = it.request().newBuilder()
                    .addHeader("X-Api-Key", BuildConfig.NEWS_API_KEY)
                    .build()
                it.proceed(newRequest)
            }
            .addInterceptor(logging)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(client)
            .build()
    }

    /*-- Provide Service --*/

    @Provides
    @Singleton
    fun provideNewsService(retrofit: Retrofit): NewsService {
        return retrofit.create(NewsService::class.java)
    }

    /*-- Provide Repo --*/

    @Singleton
    @Provides
    fun provideNewsRepo(newsService: NewsService): NewsRepo {
        return NewsRepoImpl(newsService)
    }
}