package com.example.tarea1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class ButtonsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_buttons, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val normalButton: Button = view.findViewById(R.id.btn_normal)
        val imageButton: ImageButton = view.findViewById(R.id.btn_image)

        // Cambia esto al ID correcto que tengas en tu XML
        val tvResult: TextView = view.findViewById(R.id.txt_button_result) // o el ID que uses

        normalButton.setOnClickListener {
            tvResult.text = getString(R.string.normal_button_pressed)
            Toast.makeText(context, getString(R.string.normal_button_pressed), Toast.LENGTH_SHORT).show()
        }

        imageButton.setOnClickListener {
            tvResult.text = getString(R.string.image_button_pressed)
            Toast.makeText(context, getString(R.string.image_button_pressed), Toast.LENGTH_SHORT).show()
        }
    }
}