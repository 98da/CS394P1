package com.ozu.cs394

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.cs394.R
import com.example.cs394.databinding.FragmentSignUpBinding

class SignUp : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentSignUpBinding>(inflater,
            R.layout.fragment_sign_up,container,false)
        binding.signUpButton.setOnClickListener{  view:View ->
            view.findNavController().navigate(R.id.action_signUp_to_loginPage)

        }
        return binding.root
    }

}