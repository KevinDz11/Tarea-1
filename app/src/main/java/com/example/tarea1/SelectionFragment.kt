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

        val checkBox: CheckBox = view.findViewById(R.id.checkbox)
        val radioGroup: RadioGroup = view.findViewById(R.id.radio_group)
        val switchCompat: SwitchCompat = view.findViewById(R.id.switch_element)
        val btnShow: Button = view.findViewById(R.id.btn_show_selection)
        val tvResult: TextView = view.findViewById(R.id.tv_selection_result)

        btnShow.setOnClickListener {
            val selection = StringBuilder()

            // CheckBox
            selection.append("CheckBox: ${if (checkBox.isChecked) "Sí" else "No"}\n")

            // RadioButtons
            val selectedRadioId = radioGroup.checkedRadioButtonId
            if (selectedRadioId != -1) {
                val radioButton: RadioButton = view.findViewById(selectedRadioId)
                selection.append("Radio: ${radioButton.text}\n")
            } else {
                selection.append("Radio: Ninguno seleccionado\n")
            }

            // SwitchCompat
            selection.append("Switch: ${if (switchCompat.isChecked) "ON" else "OFF"}")

            tvResult.text = selection.toString()
        }
    }
}