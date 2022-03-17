package com.example.cloneuiifood

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import co.tiagoaguiar.atway.ui.adapter.ATAdapter
import com.example.cloneuiifood.databinding.FragmentRestaurantBinding

class RestaurantFragment : Fragment(R.layout.fragment_restaurant) {

    private lateinit var binding: FragmentRestaurantBinding

    private val categoryAdapter = ATAdapter({ CategoryView(it) })

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
            Category(1, "https://www.ifood.com.br/static/images/categories/market.png", "Mercado", 0xFFB6D048),
            Category(2, "https://www.ifood.com.br/static/images/categories/restaurant.png", "Restaurantes", 0xFFE91D2D),
            Category(3, "https://www.ifood.com.br/static/images/categories/drinks.png", "Bebidas", 0xFFF6D553),
            Category(4, "https://static-images.ifood.com.br/image/upload/f_auto/webapp/landingV2/express.png", "Express", 0xFFFF0000),
            Category(5, "https://parceiros.ifood.com.br/static/media/salad.9db040c0.png", "Saudável", 0xFFE91D2D),
            Category(6, "https://www.ifood.com.br/static/images/categories/restaurant.png", "Salgados", 0xFF8C60C5),

        )

        // NO LUGAR DO setContentView, USA-SE:
        binding = FragmentRestaurantBinding.bind(view)

        binding.let {
            it.rvCategory.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            it.rvCategory.adapter = categoryAdapter

            filters.forEach { filter ->
                it.chipGroupFilter.addView(filter.toChip(requireContext()))
            }
        }

    }


}