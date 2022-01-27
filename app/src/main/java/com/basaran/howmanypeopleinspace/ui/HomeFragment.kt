package com.basaran.howmanypeopleinspace.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.basaran.howmanypeopleinspace.R
import com.basaran.howmanypeopleinspace.data.remote.APIService
import com.basaran.howmanypeopleinspace.data.remote.RetrofitClient
import com.basaran.howmanypeopleinspace.data.remote.regres.SpaceListResponse
import com.basaran.howmanypeopleinspace.databinding.FragmentHomeBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response





class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)


        val retrofit = RetrofitClient.getRetrofitClient()
        val apiService = retrofit.create(APIService::class.java)
        val callSpaceList = apiService.getSpaceList()

        callSpaceList.enqueue(object : Callback<SpaceListResponse> {
            override fun onResponse(
                call: Call<SpaceListResponse>,
                response: Response<SpaceListResponse>
            ) {
                val number = response.body()?.number.toString()
                binding.txtnumber.text = number
            }

            override fun onFailure(call: Call<SpaceListResponse>, t: Throwable) {
            }

        })


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnDetay.setOnClickListener {

/*
            val fragment = SecondFragment()
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.addToBackStack("MALES")
                ?.commit()

 */

            findNavController().navigate(R.id.action_homeFragment_to_secondFragment)

/*
            val nextaction = HomeFragmentDirections.actionHomeFragmentToSecondFragment()
            Navigation.findNavController(it).navigate(nextaction)

 */
        }
    }




}
