

package com.example.register_fragment

import android.graphics.Color
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.register_fragment.databinding.FragmentLoginBinding
import com.example.register_fragment.databinding.FragmentRegisterBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RegisterFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RegisterFragment : Fragment() {
    private lateinit var registerBinding: FragmentRegisterBinding


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
        // Inflate the layout for this fragment
        registerBinding = FragmentRegisterBinding.inflate(inflater, container, false)
        val view = registerBinding.root

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Gunakan with(registerBinding) untuk mengakses properti ViewBinding di sini
        if (registerBinding != null) {
            with(registerBinding) {
                this?.registerButton?.setOnClickListener {
                    val username = usernameEdittext.text.toString()
                    val email = emailEdittext.text.toString()
                    val password = passwordEdittext.text.toString()
                    val phone = phoneEdittext.text.toString()
                    val termsAccepted = termsCheckbox.isChecked

                    if (username.isEmpty() || email.isEmpty() || password.isEmpty() || phone.isEmpty()) {
                        Toast.makeText(
                            requireContext(),
                            "Mohon isi semua field",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else if (!termsAccepted) {
                        Toast.makeText(
                            requireContext(),
                            "Mohon terima syarat dan ketentuan",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        LogRegActivity.username = usernameEdittext.text.toString()
                        LogRegActivity.password = passwordEdittext.text.toString()
                        Toast.makeText(
                            requireContext(),
                            "Register berhasil",
                            Toast.LENGTH_SHORT
                        ).show()

//                        Pindah ke Fragment Login
                        LogRegActivity.viewPager2.setCurrentItem(1)
                        usernameEdittext.setText("")
                        passwordEdittext.setText("")
                        emailEdittext.setText("")
                        phoneEdittext.setText("")
                        termsCheckbox.isChecked = false

                    }
                }

                login.setOnClickListener(){
                    LogRegActivity.viewPager2.setCurrentItem(1)
                    usernameEdittext.setText("")
                    passwordEdittext.setText("")
                    emailEdittext.setText("")
                    phoneEdittext.setText("")
                    termsCheckbox.isChecked = false
                }

//                Mengganti warna teks terms condition
                val text = bycheckingTextview.text
                val spannable = SpannableString(text)

                val startIndexTerms = text.indexOf("Terms")
                val endIndexTerms = startIndexTerms + "Terms".length
                val startIndexConditions = text.indexOf("Conditions")
                val endIndexConditions = startIndexConditions + "Conditions".length

                spannable.setSpan(ForegroundColorSpan(Color.BLUE), startIndexTerms, endIndexTerms, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
                spannable.setSpan(ForegroundColorSpan(Color.BLUE), startIndexConditions, endIndexConditions, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)

                bycheckingTextview.text = spannable


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
         * @return A new instance of fragment RegisterFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}