package com.example.flo

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.flo.databinding.FragmentHomeBinding
import me.relex.circleindicator.CircleIndicator3
import java.util.Timer
import kotlin.concurrent.scheduleAtFixedRate

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    private val timer = Timer()
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.homeTodayMusicAlbumIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction().replace(R.id.main_frm,AlbumFragment()).commitAllowingStateLoss()
        }

        //중간 배너
        val bannerAdater = BannerVPAdapter(this)
        bannerAdater.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdater.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        bannerAdater.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp))
        bannerAdater.addFragment(BannerFragment(R.drawable.img_home_viewpager_exp2))
        binding.homeBannerVp.adapter = bannerAdater
        binding.homeBannerVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        //메인 배너
        val topBannerAdapter = BannerVPAdapter(this)
        topBannerAdapter.addFragment(MainBannerFragment(R.drawable.img_first_album_default))
        topBannerAdapter.addFragment(MainBannerFragment(R.drawable.img_first_album_default))
        topBannerAdapter.addFragment(MainBannerFragment(R.drawable.img_first_album_default))
        topBannerAdapter.addFragment(MainBannerFragment(R.drawable.img_first_album_default))
        binding.homePannelBackgroundVp.adapter = topBannerAdapter
        binding.homePannelBackgroundVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.homePannelIndicator.setViewPager(binding.homePannelBackgroundVp)

        startAutoSlide(topBannerAdapter)

        return binding.root
    }


    private fun startAutoSlide(adpater : BannerVPAdapter) {
        // 일정 간격으로 슬라이드 변경 (3초마다)
        timer.scheduleAtFixedRate(3000, 3000) {
            handler.post {
                val nextItem = binding.homePannelBackgroundVp.currentItem + 1
                if (nextItem < adpater.itemCount) {
                    binding.homePannelBackgroundVp.currentItem = nextItem
                } else {
                    binding.homePannelBackgroundVp.currentItem = 0 // 마지막 페이지에서 첫 페이지로 순환
                }
            }
        }
    }
}