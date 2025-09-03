package com.example.tarea1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedViewModel = ViewModelProvider(requireActivity())[SharedViewModel::class.java]
        val tvSharedText: TextView = view.findViewById(R.id.tv_shared_text)
        val progressBar: ProgressBar = view.findViewById(R.id.progress_bar)
        val tvProgress: TextView = view.findViewById(R.id.tv_progress)
        val btnStartProgress: Button = view.findViewById(R.id.btn_start_progress)

        sharedViewModel.sharedText.observe(viewLifecycleOwner) { text ->
            if (!text.isNullOrEmpty()) {
                tvSharedText.text = getString(R.string.shared_text_format, text)
            }
        }

        tvProgress.text = getString(R.string.progress_initial)

        btnStartProgress.setOnClickListener {
            progressBar.progress = 0
            tvProgress.text = getString(R.string.progress_initial)

            Thread {
                for (i in 1..100) {
                    Thread.sleep(50)
                    requireActivity().runOnUiThread {
                        progressBar.progress = i
                        tvProgress.text = getString(R.string.progress_format, i)
                    }
                }
            }.start()
        }
    }
}