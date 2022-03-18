package com.example.cloneuiifood


import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.example.cloneuiifood.databinding.BannerItemBinding
import com.squareup.picasso.Picasso

class BannerView(viewGroup: ViewGroup) : ATViewHolder<Banner, BannerItemBinding>(
    BannerItemBinding::inflate,
    viewGroup
) {

    override fun bind(item: Banner) {

        Picasso.get()
            .load(item.bannerUrl)
            .into(binding.imgBanner)
    }
}