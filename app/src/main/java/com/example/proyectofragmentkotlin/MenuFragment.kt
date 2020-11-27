package com.example.proyectofragmentkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_menu.*

class MenuFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        buttonCalculadora.setOnClickListener {
            val directions = MenuFragmentDirections.actionMenuFragmentToCalculadoraMainFragment()
            Navigation.findNavController(it).navigate(directions)
        }
        buttonCamara.setOnClickListener {
            val directions = MenuFragmentDirections.actionMenuFragmentToCamaraMainFragment()
            Navigation.findNavController(it).navigate(directions)
        }
        buttonWeb.setOnClickListener {
            val directions = MenuFragmentDirections.actionMenuFragmentToBuscadorMainFragment()
            Navigation.findNavController(it).navigate(directions)
        }
    }
}