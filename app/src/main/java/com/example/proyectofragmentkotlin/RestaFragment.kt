package com.example.proyectofragmentkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_resta.*
import kotlinx.android.synthetic.main.fragment_suma.*

class RestaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val resultado = RestaFragmentArgs.fromBundle(it).resultadoResta
            val num1Mostrar = RestaFragmentArgs.fromBundle(it).num1Rest
            val num2Mostrar = RestaFragmentArgs.fromBundle(it).num2Rest
            textViewResultadoResta.text = resultado
            textViewRestaProceso.text = "$num1Mostrar - $num2Mostrar"
        }
    }

}