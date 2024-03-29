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
import com.basaran.howmanypeopleinspace.adapter.SpaceAdapter
import com.basaran.howmanypeopleinspace.databinding.FragmentSecondBinding
import com.basaran.howmanypeopleinspace.model.CraftInfo
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SecondFragment : Fragment(), CraftInfo {

    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: SecondFragmentViewModel
    private lateinit var secondAdapter: SpaceAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SecondFragmentViewModel by viewModels()
        viewModel = tempViewModel
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_second, container, false)
        binding.secondFragment = this
        viewModel.spaceList.observe(viewLifecycleOwner, {
            secondAdapter = SpaceAdapter(it, this, requireContext())
            binding.secondAdapter = secondAdapter
        })
        return binding.root
    }

    fun imageClickSecondFragmentToHomeFragment(){
        Navigation.findNavController(binding.root).navigate(R.id.action_secondFragment_to_homeFragment)
    }

    override fun passData(position: Int, craftName: String, peopleName: String) {
        val bundle = Bundle()
        bundle.putInt("input_pos", position)
        bundle.putString("input_name", craftName)
        bundle.putString("input_image", peopleName)

        val transaction = this.parentFragmentManager.beginTransaction()
        val frag2 = CraftInfoFragment()
        frag2.arguments = bundle

        transaction.replace(R.id.fragmentContainerView, frag2)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}