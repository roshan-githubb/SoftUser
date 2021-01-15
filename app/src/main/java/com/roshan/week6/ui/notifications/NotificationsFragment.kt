package com.roshan.week6.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.roshan.week6.R

class NotificationsFragment : Fragment() {
    private lateinit var webview: WebView
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_notifications, container, false)
        webview = view.findViewById(R.id.webview)
        webview.getSettings().javaScriptEnabled = true
        webview.setWebViewClient(WebViewClient())
        webview.loadUrl("https://softwarica.edu.np/")
        return view
    }
}