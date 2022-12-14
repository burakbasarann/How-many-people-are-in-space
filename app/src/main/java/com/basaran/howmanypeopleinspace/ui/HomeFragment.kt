package com.basaran.howmanypeopleinspace.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.basaran.howmanypeopleinspace.R
import com.basaran.howmanypeopleinspace.databinding.FragmentHomeBinding
import com.chuckerteam.chucker.api.ChuckerInterceptor
import dagger.hilt.android.AndroidEntryPoint
import okhttp3.OkHttpClient
import kotlin.properties.Delegates


@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomePageViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_home, container, false)
        binding.homePageObj = this

        viewModel.spaceNumber.observe(viewLifecycleOwner, {
            binding.txtnumber.text = it.toString()
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: HomePageViewModel by viewModels()
        viewModel = tempViewModel
        setHasOptionsMenu(true)
    }


    fun buttonHomeFragmentToSecondFragment() {
        Navigation.findNavController(binding.root)
            .navigate(R.id.action_homeFragment_to_secondFragment)
    }
}