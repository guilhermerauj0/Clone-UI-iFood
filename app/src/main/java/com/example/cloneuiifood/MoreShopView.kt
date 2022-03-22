package com.example.cloneuiifood

import android.view.ViewGroup
import co.tiagoaguiar.atway.ui.adapter.ATViewHolder
import com.example.cloneuiifood.databinding.MoreShopItemBinding
import com.example.cloneuiifood.databinding.ShopItemBinding
import com.squareup.picasso.Picasso

class MoreShopView(viewGroup: ViewGroup) : ATViewHolder<MoreShop, MoreShopItemBinding>(
    MoreShopItemBinding::inflate,
    viewGroup
) {

    override fun bind(item: MoreShop) {

        Picasso.get()
            .load(item.bannerUrl)
            .into(binding.imgShop)

        binding.txtShop.text = item.text
        binding.txtStar.text = item.rate.toString()
        // UTILIZANDO STRINGS DINAMICAS
        binding.txtSubtitle.text = itemView.context.getString(R.string.shop_category, item.category, item.distance)
        binding.txtPrice.text = itemView.context.getString(R.string.shop_price, item.time, item.price)
    }
}