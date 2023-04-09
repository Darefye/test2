package com.example.test2.presentation.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.test2.R
import com.example.test2.presentation.MainViewModel
import com.example.test2.utils.Constants.Companion.ONE
import com.example.test2.utils.Constants.Companion.TWO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoadingScreenFragment : Fragment() {

    private val viewModel by viewModels<MainViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_loading_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.responseLiveData.observe(viewLifecycleOwner) { response ->
            when (response) {
                ONE -> findNavController().navigate(R.id.action_loadingScreenFragment_to_wallpaperFragment)
                TWO -> findNavController().navigate(R.id.action_loadingScreenFragment_to_webFragment)
                else -> Log.d("ErrorTag", "Error from LoadingScreenFragment")
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = LoadingScreenFragment()
    }
}