package com.portafoliowebmariano.rickandmortyapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.portafoliowebmariano.rickandmortyapp.R
import com.portafoliowebmariano.rickandmortyapp.databinding.FragmentCharactersBinding
import com.portafoliowebmariano.rickandmortyapp.model.data.CharacterData
import com.portafoliowebmariano.rickandmortyapp.model.data.Result
import com.portafoliowebmariano.rickandmortyapp.ui.adapter.CharacterAdapter
import com.portafoliowebmariano.rickandmortyapp.viewmodel.CharactersViewModel


class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding
    private lateinit var adapter: CharacterAdapter
    private val characterViewModel : CharactersViewModel by viewModels()
    private val manager =LinearLayoutManager(context)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharactersBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intUI()
        observer()
    }

    private fun observer() {
        characterViewModel.characters.observe(viewLifecycleOwner){ allCharacters ->
            initRecyclerView(allCharacters.results)
        }
    }

    private fun initRecyclerView(characters : List<Result>) {
        adapter = CharacterAdapter(characters)
        binding.rvCharacters.layoutManager = manager
        binding.rvCharacters.adapter = adapter
    }

    private fun intUI() {
        characterViewModel.getALlCharacters()
    }
}