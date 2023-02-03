package com.cursosandroidant.coupons

import android.app.Application
import androidx.room.Room
import com.cursosandroidant.coupons.common.dataAccess.CouponDatabase

/****
 * Project: Coupons
 * From: com.cursosandroidant.coupons
 * Created by Alain Nicolás Tello on 23/02/22 at 19:22
 * All rights reserved 2022.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class CouponsApplication : Application(){
   companion object{
      lateinit var database: CouponDatabase
   }

   override fun onCreate() {
      super.onCreate()

      database = Room.databaseBuilder(this,
       CouponDatabase::class.java,
       "CouponDatabase")
       .build()
   }
}