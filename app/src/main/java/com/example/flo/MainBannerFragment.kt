package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.flo.databinding.FragmentBannerBinding
import com.example.flo.databinding.FragmentMainBannerBinding

class MainBannerFragment(val imgRes : Int) : Fragment() {

    lateinit var  binding : FragmentMainBannerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBannerBinding.inflate(inflater, container ,false)

        binding.bannerImageIv.setImageResource(imgRes)
        return binding.root
    }
}