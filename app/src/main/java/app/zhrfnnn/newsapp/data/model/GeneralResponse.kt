package app.zhrfnnn.newsapp.data.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Zharfan on 7/16/2023.
 */

abstract class GeneralResponse(
    @SerializedName("status") var status: String? = null,
    @SerializedName("totalResults") var totalResults: Int? = null,
    @SerializedName("code") var code: String? = null,
    @SerializedName("message") var message: String? = null,
){
    fun isSuccess() : Boolean {
        return status.equals("ok")
    }
}