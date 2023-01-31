package com.example.appnavfragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.appnavfragment.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentHomeBinding.inflate(layoutInflater)
        navController = findNavController()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val viewBtn = view.findViewById<AppCompatButton>(R.id.home_button)
        viewBtn.setOnClickListener {
            Log.i("MSG", "Button Clicked")
            navigate()
        }
        return view
    }

    private fun navigate() {
        val toast = Toast.makeText(requireContext(), "Button was clicked!", Toast.LENGTH_SHORT)
        toast.show()
        navController.navigate(R.id.nextFragment)
    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }

}