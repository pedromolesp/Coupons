package com.cursosandroidant.coupons.common.adapters

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.cursosandroidant.coupons.R

/****
 * Project: Coupons
 * From: com.cursosandroidant.coupons.common.adapters
 * Created by Alain Nicolás Tello on 24/02/22 at 13:56
 * All rights reserved 2022.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
     @BindingAdapter("isGone")
     fun bindIsGone(view: View, isGone: Boolean){
         view.visibility = if (isGone) View.GONE else View.VISIBLE
     }

    @BindingAdapter("textTitle")
    fun bindTextTitle(view: TextView, isActive: Boolean){
        if (isActive){
            view.setText(R.string.main_text_title)
            view.setTextColor(Color.BLACK)
        } else {
            view.setText(R.string.main_text_title_create)
            view.setTextColor(Color.MAGENTA)
        }
    }