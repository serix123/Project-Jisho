package com.example.appnavfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.appnavfragment.databinding.FragmentNextBinding
import com.example.appnavfragment.domain.Vocabulary
import com.example.appnavfragment.presentation.VocabularyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NextFragment : Fragment() {


    private lateinit var binding: FragmentNextBinding
    private lateinit var navController: NavController
    lateinit var vocabularyViewModel: VocabularyViewModel

//    private val vocabularyViewModel: VocabularyViewModel by lazy {
//        ViewModelProvider(this)[VocabularyViewModel::class.java]
//    }

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
        val activity = requireActivity()
        vocabularyViewModel = ViewModelProvider(activity).get(VocabularyViewModel::class.java)
        binding.submitBtn.setOnClickListener {
            addVocabulary()
        }
    }

    private fun navigate() {
        val toast = Toast.makeText(requireContext(), "Button was clicked!", Toast.LENGTH_SHORT)
        toast.show()
        navController.navigate(R.id.homeFragment)
    }

    private fun addVocabulary() {
        val hiragana = binding.wordTextInputEditText.text.toString()
        val meaning = binding.meaningTextInputEditText.text.toString()
        val kanji = binding.kanjiTextInputEditText.text.toString()
        val vocabulary = Vocabulary(word = hiragana, meaning = meaning, kanji = kanji)
        vocabularyViewModel.insertVocabulary(vocabulary)
        binding.wordTextInputEditText.setText("")
        binding.meaningTextInputEditText.setText("")
        binding.meaningTextInputEditText.clearFocus()
//        vocabularyViewModel.getAllVocabulary()
        val toast = Toast.makeText(requireContext(), "Word added!", Toast.LENGTH_SHORT)
        toast.show()
        navController.popBackStack()
    }
}