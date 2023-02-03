package com.cursosandroidant.coupons.common.dataAccess

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cursosandroidant.coupons.common.entities.CouponEntity

/****
 * Project: Coupons
 * From: com.cursosandroidant.coupons
 * Created by Alain Nicolás Tello on 23/02/22 at 19:20
 * All rights reserved 2022.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
@Database(entities = [CouponEntity::class], version = 1)
abstract class CouponDatabase : RoomDatabase(){
   abstract fun couponDao(): CouponDao
}