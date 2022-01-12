package com.ozu.cs394
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.cs394.R
import com.example.cs394.databinding.FragmentLoginPageBinding
import kotlinx.android.synthetic.main.fragment_sign_up.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.delay

class MainActivity : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        val binding = DataBindingUtil.inflate<FragmentLoginPageBinding>(inflater,
            R.layout.fragment_login_page,container,false)
        binding.btnLogin.setOnClickListener{  view:View ->
            view.findNavController().navigate(com.example.cs394.R.id.action_.action_loginPage_to_mainPage)
        }
        binding.btnRegister.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_loginPage_to_signUp)
        }
        binding.fPassword.setOnClickListener{  view:View ->
            view.findNavController().navigate(R.id.action_loginPage_to_f_password)

        }
        return binding.root
    }


}