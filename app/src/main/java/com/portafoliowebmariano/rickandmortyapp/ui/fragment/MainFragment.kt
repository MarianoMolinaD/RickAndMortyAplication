package com.portafoliowebmariano.rickandmortyapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.portafoliowebmariano.rickandmortyapp.R
import com.portafoliowebmariano.rickandmortyapp.databinding.FragmentMainBinding
import com.portafoliowebmariano.rickandmortyapp.model.Repository
import com.portafoliowebmariano.rickandmortyapp.model.data.Result
import com.portafoliowebmariano.rickandmortyapp.model.network.CharactesServices
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.math.log

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
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
        initAplicartion()
    }

    private fun initAplicartion() {
        Log.i("Mitag", "Entra")
        var response = CharactesServices()
        CoroutineScope(Dispatchers.IO).launch {
            var result = response.getCharactersApi().results

            for (resultados in result){
                Log.i("Mitag", resultados.name)
            }
        }
    }

    private fun initController() {
        binding.cardPersonajes.setOnClickListener{
            findNavController().navigate(R.id.action_mainFragment_to_characterInformationFragment)
        }
    }
}