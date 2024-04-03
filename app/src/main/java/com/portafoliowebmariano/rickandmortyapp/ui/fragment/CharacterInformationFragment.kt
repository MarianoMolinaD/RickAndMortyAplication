package com.portafoliowebmariano.rickandmortyapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.portafoliowebmariano.rickandmortyapp.R
import com.portafoliowebmariano.rickandmortyapp.databinding.FragmentCharacterInformationBinding
import com.portafoliowebmariano.rickandmortyapp.viewmodel.CharactersViewModel
import com.squareup.picasso.Picasso


class CharacterInformationFragment : Fragment() {

    private lateinit var binding: FragmentCharacterInformationBinding

    private val characteViewModel: CharactersViewModel by viewModels()
    private val args: CharacterInformationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCharacterInformationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
        controller()
    }

    private fun controller() {
        binding.containerBar.btnBack.setOnClickListener {
            findNavController().navigate(R.id.action_characterInformationFragment_to_charactersFragment)
        }
    }

    private fun initUI() {
        characteViewModel.getCharacterData(args.id)
        characteViewModel.characterData.observe(viewLifecycleOwner) { character ->
            val episodios = character.episode.size.toString()
            binding.tvName.text = character.name
            binding.tvHuman.text = character.species
            if (character.type.isNotEmpty()){
                binding.tvType.text = character.type
            }else{
                binding.tvType.text = "unknown"
            }
            binding.tvGender.text = character.gender
            binding.tvOrigin.text = character.origin.name
            binding.tvLocation.text = character.location.name
            binding.tvEpisodes.text = episodios
            binding.tvStatus.text = character.status

            colorStatus(character.status)

            Picasso.get().load(character.image).into(binding.ivCharacter)
        }
    }

    private fun message(id: Int) {
        Toast.makeText(context, id.toString(), Toast.LENGTH_SHORT).show()
    }

    private fun colorStatus(status: String) {
        when (status) {
            "Alive" -> {
                binding.flStatus.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.backgrounAlive
                    )
                )
                binding.cvStatus.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.backgrounAlive
                    )
                )


            }

            "Dead" -> {
                binding.flStatus.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.backgrounDead
                    )
                )
                binding.cvStatus.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.backgrounDead
                    )
                )

            }

            "unknown" -> {
                binding.flStatus.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.backgrounUnknown
                    )
                )
                binding.cvStatus.setBackgroundColor(
                    ContextCompat.getColor(
                        requireContext(),
                        R.color.backgrounUnknown
                    )
                )
            }
        }
    }
}