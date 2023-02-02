package com.example.appnavfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.appnavfragment.databinding.FragmentNextBinding

class NextFragment : Fragment() {


    private lateinit var binding: FragmentNextBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNextBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.navButton.setOnClickListener {
            navigate()
        }
    }

    private fun navigate() {
        val toast = Toast.makeText(requireContext(), "Button was clicked!", Toast.LENGTH_SHORT)
        toast.show()
        navController.navigate(R.id.homeFragment)
    }

    companion object {
        fun newInstance(): NextFragment {
            return NextFragment()
        }
    }
}