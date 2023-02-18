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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.appnavfragment.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController
    private val wordViewModel: WordViewModel by lazy {
        ViewModelProvider(this)[WordViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.homeButton.setOnClickListener {
            Log.i("MSG", "Button Clicked")
            addVocabulary()
        }
        wordViewModel.vocabulary.observe(viewLifecycleOwner, Observer { it ->
            it.forEach { Log.i("MSG", "${it.word} => ${it.meaning}") }
        })
        return binding.root
    }

    private fun navigate() {
        val toast = Toast.makeText(requireContext(), "Button was clicked!", Toast.LENGTH_SHORT)
        toast.show()
        navController.navigate(R.id.nextFragment)
    }

    private fun addVocabulary(){
        val hiragana = binding.wordTextInputEditText.text.toString()
        val meaning = binding.meaningTextInputEditText.text.toString()
        val word = Word(word = hiragana, meaning = meaning)
        wordViewModel.addVocabulary(word)
        binding.wordTextInputEditText.setText("")
        binding.meaningTextInputEditText.setText("")
        binding.meaningTextInputEditText.clearFocus()
        val toast = Toast.makeText(requireContext(), "Word added!", Toast.LENGTH_SHORT)
        toast.show()
    }


}