package com.example.tarea1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class TextFieldsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_text_fields, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]

        val editText: EditText = view.findViewById(R.id.edit_text)
        val btnSubmit: Button = view.findViewById(R.id.btn_submit)

        btnSubmit.setOnClickListener {
            val text = editText.text.toString()
            if (text.isNotEmpty()) {
                sharedViewModel.setSharedText(text)
                Toast.makeText(context, "Texto enviado: $text", Toast.LENGTH_SHORT).show()
                editText.text.clear()
            } else {
                Toast.makeText(context, "Ingresa texto primero", Toast.LENGTH_SHORT).show()
            }
        }
    }
}