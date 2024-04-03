package com.portafoliowebmariano.rickandmortyapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.portafoliowebmariano.rickandmortyapp.R
import com.portafoliowebmariano.rickandmortyapp.databinding.FragmentEpisodesBinding
import com.portafoliowebmariano.rickandmortyapp.model.data.Episode
import com.portafoliowebmariano.rickandmortyapp.model.data.Result
import com.portafoliowebmariano.rickandmortyapp.ui.adapter.CharacterAdapter
import com.portafoliowebmariano.rickandmortyapp.ui.adapter.EpisodeAdapter
import com.portafoliowebmariano.rickandmortyapp.viewmodel.CharactersViewModel

class EpisodesFragment : Fragment() {
    private lateinit var binding: FragmentEpisodesBinding
    private lateinit var adapter : EpisodeAdapter

//    Para que se muestre orizontal
//    private val manager = LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
    private val manager = GridLayoutManager(context,2)// Para que se muestren unicamente dos columnas


    private val charactersViewModel : CharactersViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentEpisodesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intUI()
        initController()
    }

    private fun initController() {
        binding.containerBar.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun intUI() {
        charactersViewModel.getListEpisodes()
        charactersViewModel.listEpisodes.observe(viewLifecycleOwner){ episodes ->
            initRecyclerView(episodes)
        }
    }

    private fun initRecyclerView(episodes : MutableList<Episode>) {
        adapter = EpisodeAdapter(episodes)
        binding.rvEpisodes.layoutManager = manager
        binding.rvEpisodes.adapter = adapter
        adapter.notifyDataSetChanged()
    }
}