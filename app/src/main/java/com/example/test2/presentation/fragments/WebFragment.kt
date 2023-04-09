package com.example.test2.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.test2.databinding.FragmentWebBinding
import com.example.test2.utils.Constants.Companion.WEB_URL
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WebFragment : Fragment() {
    private lateinit var binding: FragmentWebBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentWebBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val webView = WebView(requireContext())
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(WEB_URL)
            webViewClient = WebViewClient()
            canGoBack()
        }
        webView.webViewClient = WebViewClient()
        webView.loadUrl(WEB_URL)
        webView.webViewClient = WebViewClient()
        webView.canGoBack()

        binding.flWeb.addView(webView)

        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (webView.canGoBack()) {
                    webView.goBack()
                } else {
                    requireActivity().finish()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    companion object {
        @JvmStatic
        fun newInstance() = WebFragment()

    }
}