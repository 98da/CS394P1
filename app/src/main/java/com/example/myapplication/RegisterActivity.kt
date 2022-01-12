package com.example.myapplication

import android.os.Bundle
import android.content.Intent
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.fragment_sign_up.*
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.myapplication.databinding.FragmentSignUpBinding
import kotlinx.android.synthetic.main.fragment_login_page.*

class RegisterActivity : Fragment(R.layout.fragment_sign_up){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?) : View? {
        val binding = DataBindingUtil.inflate<FragmentSignUpBinding>(inflater,R.layout.fragment_sign_up,container,false)
        binding.signUpButton.setOnClickListener{  view:View ->
            view.findNavController().navigate(R.id.action_signUp_to_loginPage)
            }


        val view = inflater.inflate(R.layout.fragment_sign_up, container, false)

        loginButton.setOnClickListener{
            startActivity(Intent(this, loginPage::class.java))
        }


        signUpButton.setOnClickListener{
            val email: String = textInputEditText.text.toString().trim{ it <= ' '}
            val password: String = textInputEditText2.text.toString().trim { it <= ' '}

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener(OnCompleteListener<AuthResult> {
                task -> if(task.isSuccessful){
                    val firebaseUser: FirebaseUser = task.result!!.user!!
                    Toast.makeText(this@RegisterActivity, "You are sign up successfully.", Toast.LENGTH_SHORT).show()

                    val intent = Intent(this@RegisterActivity, MainActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    intent.putExtra("user_id", firebaseUser.uid)
                    intent.putExtra("email_id", email)
                    startActivity(intent)
                    finish()
                }else{
                    Toast.makeText(this@RegisterActivity, task.exception!!.message.toString(), Toast.LENGTH_SHORT).show()
                }
            }
            )
        }

        return binding.root
    }
}