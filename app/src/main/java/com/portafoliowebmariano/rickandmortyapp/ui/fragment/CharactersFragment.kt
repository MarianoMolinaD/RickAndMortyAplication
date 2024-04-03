package com.portafoliowebmariano.rickandmortyapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.portafoliowebmariano.rickandmortyapp.R
import com.portafoliowebmariano.rickandmortyapp.databinding.FragmentCharactersBinding
import com.portafoliowebmariano.rickandmortyapp.model.data.CharacterData
import com.portafoliowebmariano.rickandmortyapp.model.data.Result
import com.portafoliowebmariano.rickandmortyapp.model.data.ResultList
import com.portafoliowebmariano.rickandmortyapp.model.provider.CharactersProvider
import com.portafoliowebmariano.rickandmortyapp.ui.adapter.CharacterAdapter
import com.portafoliowebmariano.rickandmortyapp.viewmodel.CharactersViewModel


class CharactersFragment : Fragment() {

    private lateinit var binding: FragmentCharactersBinding
    private lateinit var adapter: CharacterAdapter
    private val characterViewModel: CharactersViewModel by viewModels()
    private val manager = LinearLayoutManager(context)
    private val character = CharactersProvider.CharactersRM

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

        controller()
    }

    private fun controller() {
        binding.containerBar.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_charactersFragment_to_mainFragment)
        }
    }

    private fun initRecyclerView(characters: MutableList<ResultList>) {
        adapter = CharacterAdapter(characters) { id ->
            openInfoCharacter(id)
        }
        binding.rvCharacters.layoutManager = manager
        binding.rvCharacters.adapter = adapter
    }


    private fun intUI() {
        val listCharacter = CharactersProvider.CharactersRM
        initRecyclerView(listCharacter!!)
    }

    private fun openInfoCharacter(id: Int) {
        findNavController().navigate(
            CharactersFragmentDirections.actionCharactersFragmentToCharacterInformationFragment(id)
        )
    }
}