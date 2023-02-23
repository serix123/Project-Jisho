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
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appnavfragment.databinding.FragmentHomeBinding
import com.example.appnavfragment.presentation.VocabularyViewModel
import com.example.appnavfragment.presentation.components.VocabularyListAdapter
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.Contexts

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var navController: NavController

    //    private val vocabularyViewModel: VocabularyViewModel by lazy {
//        ViewModelProvider(this)[VocabularyViewModel::class.java]
//    }
    lateinit var vocabularyViewModel: VocabularyViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController = findNavController()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val activity = requireActivity()
        vocabularyViewModel = ViewModelProvider(activity).get(VocabularyViewModel::class.java)
        vocabularyViewModel.getAllVocabulary()
        setRecyclerView()
        binding.addVocabularyFAB.setOnClickListener {
            navigate()
        }
    }

    private fun setRecyclerView() {

        vocabularyViewModel.vocabularyLiveData.observe(viewLifecycleOwner) {
            if (it.isEmpty()) {
                binding.vocabularyList.visibility = View.GONE
                binding.emptyListTextView.visibility = View.VISIBLE
            } else {
                binding.vocabularyList.visibility = View.VISIBLE
                binding.emptyListTextView.visibility = View.GONE

            }
            binding.vocabularyList.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = VocabularyListAdapter(it)
            }
        }
    }

    private fun navigate() {
        val toast = Toast.makeText(requireContext(), "Going to next screen", Toast.LENGTH_SHORT)
        toast.show()
        navController.navigate(R.id.nextFragment)
    }


}