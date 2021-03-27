package com.example.sharedviewmodel

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.a.*

class A : Fragment(R.layout.a) {
    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sharedViewModel.currentNumber.observe(viewLifecycleOwner, Observer {
            number.text = it.toString()
        })

        sharedViewModel.currentBoolean.observe(viewLifecycleOwner, Observer {
            bool.text = it.toString()
        })

        increment()

        button2.setOnClickListener {
            findNavController().navigate(R.id.action_a_to_b)
        }
    }

    private fun increment() {
        button.setOnClickListener {
            sharedViewModel.currentNumber.value = sharedViewModel.number++;
            sharedViewModel.currentBoolean.value = sharedViewModel.number % 2 == 0;

        }
    }
}