package com.example.proyectofragmentkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_buscador_main.*

class BuscadorMainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_buscador_main, container, false)
    }

    companion object {

        fun newInstance(param1: String, param2: String) =
            BuscadorMainFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val BASE_URL = "https://google.com"
        val SEARCH_PATH = "/search?q="

        super.onViewCreated(view, savedInstanceState)

        buttonAtras.setOnClickListener(){
            if(webView.canGoBack()){
                webView.goBack()
            } else {
                Toast.makeText(activity, "No se puede ir hacia atras", Toast.LENGTH_LONG).show()
            }
        }

        buttonDelante.setOnClickListener(){
            if(webView.canGoForward()){
                webView.goForward()
            } else {
                Toast.makeText(activity, "No se puede ir hacia delante", Toast.LENGTH_LONG).show()
            }
        }

        webView.webChromeClient = object : WebChromeClient(){

        }

        webView.webViewClient = object : WebViewClient(){

        }

        val settings : WebSettings = webView.settings
        settings.javaScriptEnabled = true

        webView.loadUrl(BASE_URL)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String?): Boolean {

                query?.let {
                    if(URLUtil.isValidUrl(it)){
                        webView.loadUrl(it)
                    }else{
                        webView.loadUrl("$BASE_URL$SEARCH_PATH$it")
                    }
                }


                return false
            }
        })


    }

}