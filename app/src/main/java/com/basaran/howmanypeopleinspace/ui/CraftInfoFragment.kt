package com.basaran.howmanypeopleinspace.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.basaran.howmanypeopleinspace.R
import com.basaran.howmanypeopleinspace.databinding.FragmentCraftInfoBinding


class CraftInfoFragment : Fragment() {

    var inputPos: Int? = null
    var inputCraftName: String = ""
    var inputICraftPeople: String = ""
    private var _binding: FragmentCraftInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCraftInfoBinding.inflate(inflater, container, false)
        val view = binding.root

        inputPos = arguments?.getInt("input_pos")
        inputCraftName = arguments?.getString("input_name").toString()
        inputICraftPeople = arguments?.getString("input_image").toString()


        binding.btnCraft.text = inputCraftName
        binding.btnPeople.text = inputICraftPeople

        clickListenerrr(inputCraftName)

        binding.btnPeople.setOnClickListener {
            val str = inputICraftPeople.removeWhitespaces()
            clickListenerrr(str)
        }

        binding.btnCraft.setOnClickListener {
            clickListenerrr(inputCraftName)
        }

        binding.backbutton.setOnClickListener {
            val transaction = this.parentFragmentManager.beginTransaction()
            val frag2 = SecondFragment()

            transaction.replace(R.id.fragmentContainerView, frag2)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun clickListenerrr(girilecekUrl : String){
        binding.webView.webViewClient =object : WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, request: String?): Boolean {
                view?.loadUrl(request!!)
                return true
            }
        }
        val url = "https://en.wikipedia.org/wiki/"+girilecekUrl
        binding.webView.loadUrl(url)
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.settings.setSupportZoom(true)
    }

    fun String.removeWhitespaces() = replace(" ", "_")

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}