package com.example.ibikenavigationkotlin.adapter


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import com.example.ibikenavigationkotlin.fragment.AllFragment
import com.example.ibikenavigationkotlin.fragment.XFragment


class ViewPagerAdapter(fm: androidx.fragment.app.FragmentManager?) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment? {
        var fragment : Fragment? = null
        if (position==0){
            fragment = AllFragment()
        }
        if (position==1){
            fragment = XFragment()
        }

        return fragment
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        var title: String?=null
        if (position==0){
            title = "Tất Cả"
        }
        else if (position==1){
            title = "thường xuyên"
        }
        return title
    }
}