package com.example.proyectofragmentkotlin

import android.content.Intent.getIntent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_suma.*


class SumaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_suma, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.let {
            val resultado = SumaFragmentArgs.fromBundle(it).resultadoSum
            val num1Mostrar = SumaFragmentArgs.fromBundle(it).Num1Sum
            val num2Mostrar = SumaFragmentArgs.fromBundle(it).Num2Sum
            textViewResultadoSum.text = resultado
            textViewSumaProceso.text = "$num1Mostrar + $num2Mostrar"
        }
    }

}