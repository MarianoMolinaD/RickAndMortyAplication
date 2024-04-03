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
import com.portafoliowebmariano.rickandmortyapp.R
import com.portafoliowebmariano.rickandmortyapp.databinding.FragmentMainBinding
import com.portafoliowebmariano.rickandmortyapp.model.Repository
import com.portafoliowebmariano.rickandmortyapp.model.data.Result
import com.portafoliowebmariano.rickandmortyapp.model.network.CharactesServices
import com.portafoliowebmariano.rickandmortyapp.model.provider.CharactersProvider
import com.portafoliowebmariano.rickandmortyapp.viewmodel.CharactersViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    private val charactersViewModel : CharactersViewModel by viewModels()
    private var character = CharactersProvider.CharactersRM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentMainBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initController()
        observer()
        initUI()
    }

    private fun observer() {
        if (character.isNullOrEmpty()){
            charactersViewModel.isStarting.observe(viewLifecycleOwner){
//                binding.cardPersonajes.isEnabled = it
                binding.pbMain.isVisible = it
            }
        }

        charactersViewModel.characters.observe(viewLifecycleOwner){
            CharactersProvider.CharactersRM = it
            Log.i("Listadecharacter",it.toString())
            Log.i("Listadecharacter",character.toString())
        }
    }

    private fun initUI() {
        binding.containerBar.btnBack.isVisible = false

        if (character.isNullOrEmpty()){
            charactersViewModel.getALlCharacters()
        }
    }

    private fun initController() {
        binding.cardPersonajes.setOnClickListener{
            if(binding.cardPersonajes.isEnabled){
                findNavController().navigate(R.id.action_mainFragment_to_charactersFragment)
            }else{
                Toast.makeText(context, "Esta cargando la lista de personaajes", Toast.LENGTH_LONG).show()
            }
        }
        binding.cvEpisodes.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_episodesFragment)
        }
    }
}