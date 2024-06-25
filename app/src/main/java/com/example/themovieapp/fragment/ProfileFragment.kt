package com.example.themovieapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.themovieapp.R

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imgProfile = view.findViewById<ImageView>(R.id.img_item_photo)
        imgProfile.setImageResource(R.drawable.photo)

        val tvName = view.findViewById<TextView>(R.id.tv_item_name)
        tvName.text = getString(R.string.abid)

        val tvDesc = view.findViewById<TextView>(R.id.tv_item_description)
        tvDesc.text = getString(R.string.desc_abid)
    }
}
