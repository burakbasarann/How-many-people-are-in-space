package com.basaran.howmanypeopleinspace.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.basaran.howmanypeopleinspace.R
import com.basaran.howmanypeopleinspace.adapter.SpaceAdapter
import com.basaran.howmanypeopleinspace.data.remote.APIService
import com.basaran.howmanypeopleinspace.data.remote.RetrofitClient
import com.basaran.howmanypeopleinspace.data.remote.regres.SpaceListResponse
import com.basaran.howmanypeopleinspace.databinding.FragmentHomeBinding
import com.basaran.howmanypeopleinspace.databinding.FragmentSecondBinding
import com.basaran.howmanypeopleinspace.model.PeopleModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SecondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    var spaceList: ArrayList<PeopleModel> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val retrofit = RetrofitClient.getRetrofitClient()
        val apiService = retrofit.create(APIService::class.java)
        val callSpaceList = apiService.getSpaceList()

        callSpaceList.enqueue(object : Callback<SpaceListResponse> {
            override fun onResponse(
                call: Call<SpaceListResponse>,
                response: Response<SpaceListResponse>
            ) {

                val tempList = response.body()?.people

                tempList?.let {
                    spaceList = it as ArrayList<PeopleModel>
                }
                val spaceAdapter = SpaceAdapter(spaceList)
                binding.recyclerview.adapter = spaceAdapter
                binding.recyclerview.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                binding.recyclerview.setHasFixedSize(true)
                /*
                val spaceListResponse = response.body() as SpaceListResponse
                Toast.makeText(
                    this@MainActivity,
                    spaceListResponse.people[1].name,
                    Toast.LENGTH_LONG
                ).show()

                 */

            }

            override fun onFailure(call: Call<SpaceListResponse>, t: Throwable) {
                Toast.makeText(context, "exception", Toast.LENGTH_LONG).show()
            }


        })

        binding.imghome.setOnClickListener {
            val fragment = HomeFragment()
            val transaction = fragmentManager?.beginTransaction()
            transaction?.replace(R.id.fragmentContainerView,fragment)?.commit()

        }
    }



}