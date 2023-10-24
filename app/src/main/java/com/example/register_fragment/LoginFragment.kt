package com.example.register_fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.register_fragment.databinding.FragmentLoginBinding


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    private lateinit var loginBinding: FragmentLoginBinding
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        loginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = loginBinding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Gunakan with(loginBinding) untuk mengakses properti ViewBinding di sini
        if (loginBinding != null) {
            with(loginBinding) {
                this?.loginButton?.setOnClickListener {
                    val username = usernameEdittext.text.toString()
                    val password = passwordEdittext.text.toString()

                    if (username.isEmpty() || password.isEmpty()) {
                        Toast.makeText(
                            requireContext(),
                            "Mohon isi semua field",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else if(LogRegActivity.username!=username || LogRegActivity.password!=password){
                        Toast.makeText(
                            requireContext(),
                            "Username atau password salah",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else{
                        Toast.makeText(
                            requireContext(),
                            "Login Berhasil",
                            Toast.LENGTH_SHORT
                        ).show()

                        LogRegActivity.username = ""
                        LogRegActivity.password = ""

                        val intent = Intent(activity, MainActivity::class.java)
                        startActivity(intent)
                    }
                }

                register.setOnClickListener(){
                    LogRegActivity.viewPager2.setCurrentItem(0)
                }
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}