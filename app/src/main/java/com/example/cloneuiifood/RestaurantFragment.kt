package com.example.cloneuiifood

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import co.tiagoaguiar.atway.ui.adapter.ATAdapter
import com.example.cloneuiifood.databinding.FragmentRestaurantBinding

class RestaurantFragment : Fragment(R.layout.fragment_restaurant) {

    private lateinit var binding: FragmentRestaurantBinding

    private val categoryAdapter = ATAdapter({ CategoryView(it) })
    private val bannerAdapter = ATAdapter({ BannerView(it) })
    private val shopAdapter = ATAdapter({ShopView(it)})
    private val moreShopAdapter = ATAdapter({MoreShopView(it)})

    private var filters = arrayOf(
        FilterItem(1, "Ordenar", closeIcon = R.drawable.ic_arrow_down),
        FilterItem(2, "Pra retirar", icon = R.drawable.ic_directions_walk),
        FilterItem(3, "Entrega grátis"),
        FilterItem(4, "Vale-refeição", closeIcon = R.drawable.ic_arrow_down),
        FilterItem(5, "Distância", closeIcon = R.drawable.ic_arrow_down),
        FilterItem(6, "Entrega Parceria"),
        FilterItem(7, "Super Restaurante"),
        FilterItem(8, "Filtros", closeIcon = R.drawable.ic_filter_list)
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryAdapter.items = arrayListOf(
            Category(
                1,
                "https://www.ifood.com.br/static/images/categories/market.png",
                "Mercado",
                0xFFB6D048
            ),
            Category(
                2,
                "https://www.ifood.com.br/static/images/categories/restaurant.png",
                "Restaurantes",
                0xFFE91D2D
            ),
            Category(
                3,
                "https://www.ifood.com.br/static/images/categories/drinks.png",
                "Bebidas",
                0xFFF6D553
            ),
            Category(
                4,
                "https://static-images.ifood.com.br/image/upload/f_auto/webapp/landingV2/express.png",
                "Express",
                0xFFFF0000
            ),
            Category(
                5,
                "https://parceiros.ifood.com.br/static/media/salad.9db040c0.png",
                "Saudável",
                0xFFE91D2D
            ),
            Category(
                6,
                "https://www.ifood.com.br/static/images/categories/restaurant.png",
                "Salgados",
                0xFF8C60C5
            ),
        )

        bannerAdapter.items = arrayListOf(
            Banner(
                1,
                "https://static-images.ifood.com.br/image/upload/t_high,q_100/webapp/landing/landing-banner-1.png"
            ),
            Banner(
                2,
                "https://static-images.ifood.com.br/image/upload/t_high,q_100/webapp/landing/landing-banner-2.png"
            ),
            Banner(
                3,
                "https://static-images.ifood.com.br/image/upload/t_high,q_100/webapp/landing/landing-banner-3.png"
            )
        )

        shopAdapter.items = arrayListOf(
            Shop(1, "https://static-imagem.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Pizza Crek"),
            Shop(2, "https://static-imagem.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Fábrica de Esfiha"),
            Shop(3, "https://static-imagem.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Pecorino"),
            Shop(4, "https://static-imagem.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Barbacoa Grill"),
            Shop(5, "https://static-imagem.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Bolo de Madre"),
            Shop(6, "https://static-imagem.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Uau Esfiha"),
            Shop(7, "https://static-imagem.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Bar do Juarez"),
        )

        moreShopAdapter.items = arrayListOf(
            MoreShop(1, "https://static-imagem.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Pizza Crek", 4.4, "Pizza", 11.2, "60-70", 26.00),
            MoreShop(2, "https://static-imagem.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Pizza Crek", 4.4, "Pizza", 11.2, "60-70", 22.00),
            MoreShop(3, "https://static-imagem.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Pizza Crek", 4.4, "Pizza", 11.2, "60-70", 12.00),
            MoreShop(4, "https://static-imagem.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Pizza Crek", 4.4, "Pizza", 11.2, "60-70", 56.00),
            MoreShop(5, "https://static-imagem.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Pizza Crek", 4.4, "Pizza", 11.2, "60-70", 31.00),
            MoreShop(6, "https://static-imagem.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Pizza Crek", 4.4, "Pizza", 11.2, "60-70", 10.00),
            MoreShop(7, "https://static-imagem.ifood.com.br/image/upload/t_high/logosgde/46ebd05c-116e-41cd-b3de-7a05c5bc730a/201811071958_30656.jpg", "Pizza Crek", 4.4, "Pizza", 11.2, "60-70", 9.00),
        )

        // NO LUGAR DO setContentView, USA-SE:
        binding = FragmentRestaurantBinding.bind(view)

        binding.let {
            it.rvCategory.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvCategory.adapter = categoryAdapter

            it.rvBanners.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvBanners.adapter = bannerAdapter


            it.rvShops.layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvShops.adapter = shopAdapter

            it.rvMoreShops.layoutManager = LinearLayoutManager(requireContext())
            it.rvMoreShops.adapter = moreShopAdapter

            // SYNC DOTS COM OS BANNERS
            it.rvBanners.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    if (newState == RecyclerView.SCROLL_STATE_IDLE) { // SE ESTÁ EM ESTADO OCIOSO
                        notifyPositionChanged(recyclerView)

                    }
                }
            })

            addDots(it.dots, bannerAdapter.items.size, 0)

            filters.forEach { filter ->
                it.chipGroupFilter.addView(filter.toChip(requireContext()))
            }
        }
    }

    private var position: Int? = RecyclerView.NO_POSITION
    private val snapHelper =
        LinearSnapHelper() // FUNÇÃO DE DESCOBRIR QUAL POSIÇÃO A RECYCLER VIEW ESTÁ

    private fun notifyPositionChanged(recyclerView: RecyclerView) {
        val layoutManager = recyclerView.layoutManager
        val view = snapHelper.findSnapView(layoutManager)
        val position =
            if (view == null) RecyclerView.NO_POSITION else layoutManager?.getPosition(view)

        val positionChanged = this.position != position
        if (positionChanged) {
            addDots(binding.dots, bannerAdapter.items.size, position ?: 0)
        }
        this.position = position
    }

    private fun addDots(container: LinearLayout, size: Int, position: Int) {
        container.removeAllViews()

        Array(size) {
            val textView = TextView(context).apply {
                text = getString(R.string.dotted)
                textSize = 20f
                setTextColor(
                    if (position == it) ContextCompat.getColor(context, android.R.color.black)
                    else ContextCompat.getColor(context, android.R.color.darker_gray)
                )
            }
            container.addView(textView)
        }
    }


}