package com.example.weatherapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapplication.R
import com.example.weatherapplication.RecylerViewAdapter
import com.example.weatherapplication.WeatherModel
import com.example.weatherapplication.databinding.FragmentMainBinding

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    private lateinit var pageViewModel: PageViewModel
    private var _binding: FragmentMainBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecylerViewAdapter
    private lateinit var itemList: List<WeatherModel> // Your data model class


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pageViewModel = ViewModelProvider(this).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }

    }

    private fun generateDummyData(): List<WeatherModel> {

        val dummyList = mutableListOf(

            WeatherModel(
                day = "Perşembe, Ağu 25",
                weather = "Yağmur",
                weatherImageResId = R.drawable.cloudy_rain,
                temp = "25°",
                temp2 = "16°",
                hummiditiy = "%97"
            ),
            WeatherModel(
                day = "Cuma, Ağu 26",
                weather = "Açık",
                weatherImageResId = R.drawable.sun,
                temp = "26°",
                temp2 = "13°",
                hummiditiy = null

            ),
            WeatherModel(
                day = "Cumartesi, Ağu 27",
                weather = "Bulutlu",
                weatherImageResId = R.drawable.cloud,
                temp = "27°",
                temp2 = "18°",
                hummiditiy = null

            ),
            WeatherModel(
                day = "Pazar, Ağu 28",
                weather = "Çok Bulutlu",
                weatherImageResId = R.drawable.cloudy,
                temp = "22°",
                temp2 = "14°",
                hummiditiy = null

            ),    WeatherModel(
                day = "Pazartesi, Ağu 29",
                weather = "Yağmur",
                weatherImageResId = R.drawable.cloudy_rain,
                temp = "23°",
                temp2 = "19°",
                hummiditiy = "%95"

            )
            ,    WeatherModel(
                day = "Salı, Ağu 30",
                weather = "Açık",
                weatherImageResId = R.drawable.sun,
                temp = "26°",
                temp2 = "19°",
                hummiditiy = null

            ),
                WeatherModel(
                day = "Çarşamba, Ağu 31",
                weather = "Yağmur",
                weatherImageResId = R.drawable.cloudy_rain,
                temp = "23°",
                temp2 = "19°",
                    hummiditiy = "%67"

                ),
            WeatherModel(
                day = "Perşembe, Eyl 01",
                weather = "Yağmur",
                weatherImageResId = R.drawable.cloudy_rain,
                temp = "25°",
                temp2 = "16°",
                hummiditiy = "%56"

            ),
            WeatherModel(
                day = "Cuma, Eyl 02",
                weather = "Açık",
                weatherImageResId = R.drawable.sun,
                temp = "26°",
                temp2 = "13°",
                hummiditiy = null

            ),
            WeatherModel(
                day = "Cumartesi, Eyl 03",
                weather = "Bulutlu",
                weatherImageResId = R.drawable.cloud,
                temp = "27°",
                temp2 = "18°",
                hummiditiy = null

            ),
            WeatherModel(
                day = "Pazar, Eyl 04",
                weather = "Çok Bulutlu",
                weatherImageResId = R.drawable.cloudy,
                temp = "22°",
                temp2 = "14°",
                hummiditiy = null

            ),
        )

        return dummyList
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentMainBinding.inflate(inflater, container, false)

        recyclerView = binding.recylerview
        // Initialize your list of dummy data
        itemList = generateDummyData()

        // Create and set the adapter
        adapter = RecylerViewAdapter(itemList) // Pass your list of items to the adapter
        recyclerView.adapter = adapter

        /*
        val textView: TextView = binding.sectionLabel
        pageViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        */
        return binding.root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}