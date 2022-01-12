package com.ozu.cs394

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.cs394.R
import com.example.cs394.databinding.FragmentFPasswordBinding

class f_password : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentFPasswordBinding>(inflater,
            R.layout.fragment_f_password,container,false)
        binding.fButton.setOnClickListener{  view:View ->
            view.findNavController().navigate(R.id.action_f_password_to_loginPage)

        }
        return binding.root
    }
}



