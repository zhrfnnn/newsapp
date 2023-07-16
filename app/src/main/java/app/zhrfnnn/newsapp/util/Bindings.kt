package app.zhrfnnn.newsapp.util

import androidx.databinding.BindingAdapter
import app.zhrfnnn.newsapp.R
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView

/**
 * Created by Zharfan on 7/16/2023.
 */

@BindingAdapter("imageUrl")
fun loadImage(view: RoundedImageView, url: String?) {
    Glide.with(view.context)
        .load(url)
        .centerCrop()
        .placeholder(R.drawable.no_image)
        .error(R.drawable.no_image)
        .into(view)
}