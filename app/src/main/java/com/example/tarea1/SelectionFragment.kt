package com.example.tarea1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment

class SelectionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val checkBox: CheckBox = view.findViewById(R.id.checkBox)
        val radioGroup: RadioGroup = view.findViewById(R.id.radioGroup)
        val switchCompat: SwitchCompat = view.findViewById(R.id.switch1)
        val btnShow: Button = view.findViewById(R.id.btn_show_selection)
        val tvResult: TextView = view.findViewById(R.id.txt_selection_result)

        // Configurar el RadioGroup para que funcione correctamente
        radioGroup.setOnCheckedChangeListener { group, checkedId ->
            // Esto asegura que solo un RadioButton pueda estar seleccionado
            if (checkedId != -1) {
                // Desmarcar otros RadioButtons si es necesario
                for (i in 0 until group.childCount) {
                    val child = group.getChildAt(i)
                    if (child is RadioButton && child.id != checkedId) {
                        child.isChecked = false
                    }
                }
            }
        }

        btnShow.setOnClickListener {
            val selection = StringBuilder()

            // CheckBox
            selection.append("CheckBox: ${if (checkBox.isChecked) "Sí" else "No"}\n")

            // RadioButtons - FORMA CORRECTA
            val selectedRadioId = radioGroup.checkedRadioButtonId
            if (selectedRadioId != -1) {
                val selectedRadioButton: RadioButton = view.findViewById(selectedRadioId)
                selection.append("Radio: ${selectedRadioButton.text}\n")
            } else {
                selection.append("Radio: Ninguno seleccionado\n")
            }

            // SwitchCompat
            selection.append("Switch: ${if (switchCompat.isChecked) "ON" else "OFF"}")

            tvResult.text = selection.toString()
            tvResult.visibility = View.VISIBLE
        }

        // DEBUG: Verificar que los RadioButtons estén en el RadioGroup
        println("Número de RadioButtons en el grupo: ${radioGroup.childCount}")
        for (i in 0 until radioGroup.childCount) {
            val child = radioGroup.getChildAt(i)
            println("Hijo $i: ${child.javaClass.simpleName} - ID: ${child.id}")
        }
    }
}