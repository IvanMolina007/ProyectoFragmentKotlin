package com.example.proyectofragmentkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_multi.*
import kotlinx.android.synthetic.main.fragment_resta.*
import kotlinx.android.synthetic.main.fragment_suma.*

class MultiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_multi, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val resultado = MultiFragmentArgs.fromBundle(it).resultadoMulti
            val num1Mostrar = MultiFragmentArgs.fromBundle(it).num1Multi
            val num2Mostrar = MultiFragmentArgs.fromBundle(it).num2Multi
            textViewResultadoMulti.text = resultado
            textViewMultiProceso.text = "$num1Mostrar x $num2Mostrar"
        }
    }

}