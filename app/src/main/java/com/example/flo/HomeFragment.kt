package com.example.flo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.flo.databinding.FragmentHomeBinding
import me.relex.circleindicator.CircleIndicator3

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homeTodayMusicAlbumIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm,AlbumFragment()).commitAllowingStateLoss()
        }

        val bannerAdater = BannerVPAdapter(this)
        bannerAdater.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdater.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        bannerAdater.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdater.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        binding.homeBannerVp.adapter = bannerAdater
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val topBannerAdapter = BannerVPAdapter(this)
        topBannerAdapter.addFragment(MainBannerFragment(R.drawable.img_first_album_default))
        topBannerAdapter.addFragment(MainBannerFragment(R.drawable.img_first_album_default))
        topBannerAdapter.addFragment(MainBannerFragment(R.drawable.img_first_album_default))
        topBannerAdapter.addFragment(MainBannerFragment(R.drawable.img_first_album_default))
        binding.homePannelBackgroundVp.adapter = topBannerAdapter
        binding.homePannelBackgroundVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL


        binding.homePannelIndicator.setViewPager(binding.homePannelBackgroundVp)

        return binding.root
    }
}