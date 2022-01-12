package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.myapplication.databinding.FragmentLoginPageBinding


class loginPage : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentLoginPageBinding>(inflater,R.layout.fragment_login_page,container,false)
        binding.loginButton.setOnClickListener{  view:View ->
            view.findNavController().navigate(R.id.action_loginPage_to_mainPage)
        }
        binding.signUp.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginPage_to_signUp)
        }
        binding.fPassword.setOnClickListener{  view:View ->
            view.findNavController().navigate(R.id.action_loginPage_to_f_password)

        }
            return binding.root
    }

}