package com.example.proyectofragmentkotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_calculadora_main.*

class CalculadoraMainFragment : Fragment() {
    var resultado = 0.0
    var num1 = 0.0
    var num2 = 0.0
    var x = 0
    var y = 0
    var z = 0
    var resultado3 = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculadora_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonEnviarCal.setOnClickListener {
            if (radioButtonReglaDeTres.isChecked) {
                if (editTextNumberX.text.isNullOrEmpty() || editTextNumberY.text.isNullOrEmpty() || editTextNumberZ.text.isNullOrEmpty()) {
                    Toast.makeText(activity, "Rellena X, Y, Z", Toast.LENGTH_LONG).show()
                } else {
                    x = editTextNumberX.text.toString().toInt()
                    y = editTextNumberY.text.toString().toInt()
                    z = editTextNumberZ.text.toString().toInt()

                    if (switchSwitch.isChecked) {
                        resultado3 = (x * y)/z
                    } else {
                        resultado3 = (z * y)/x
                    }

                    val directions = CalculadoraMainFragmentDirections.actionCalculadoraMainFragmentToReglaDe3Fragment(resultadoReglaDe3 = resultado3.toString(), num1ReglaDe3 = x.toString(), num2ReglaDe3 = y.toString(), num3ReglaDe3 = z.toString())
                    Navigation.findNavController(it).navigate(directions)
                }
            } else {
                if (editTextNumber1.text.isNullOrEmpty() || editTextNumber2.text.isNullOrEmpty()) {
                    Toast.makeText(activity, "Rellena ambos campos", Toast.LENGTH_LONG).show()
                } else {
                    num1 = editTextNumber1.text.toString().toDouble()
                    num2 = editTextNumber2.text.toString().toDouble()
                    if (radioButtonSuma.isChecked) {
                        resultado = num1 + num2
                        val directions = CalculadoraMainFragmentDirections.actionCalculadoraMainFragmentToSumaFragment(resultadoSum = resultado.toString(), Num1Sum = num1.toString(), Num2Sum = num2.toString())
                        Navigation.findNavController(it).navigate(directions)
                    } else {
                        if (radioButtonResta.isChecked) {
                            resultado = num1 - num2
                            val directions = CalculadoraMainFragmentDirections.actionCalculadoraMainFragmentToRestaFragment(resultadoResta = resultado.toString(), num1Rest = num1.toString(), num2Rest = num2.toString())
                            Navigation.findNavController(it).navigate(directions)
                        } else {
                            if (radioButtonMulti.isChecked) {
                                resultado = num1 * num2
                                val directions = CalculadoraMainFragmentDirections.actionCalculadoraMainFragmentToMultiFragment(resultadoMulti = resultado.toString(), num1Multi = num1.toString(), num2Multi = num2.toString())
                                Navigation.findNavController(it).navigate(directions)
                            } else {
                                resultado = num1 / num2
                                val directions = CalculadoraMainFragmentDirections.actionCalculadoraMainFragmentToDivFragment(resultadoDiv = resultado.toString(), num1Div = num1.toString(), num2Div = num2.toString())
                                Navigation.findNavController(it).navigate(directions)
                            }
                        }
                    }
                }
            }
        }

        switchSwitch.setOnClickListener {
            if (switchSwitch.isChecked) {
                Toast.makeText(activity, "Regla de 3 inverso", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Regla de 3 normal", Toast.LENGTH_SHORT).show()
            }

        }
    }

}