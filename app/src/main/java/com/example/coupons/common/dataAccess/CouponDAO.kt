package com.cursosandroidant.coupons.common.dataAccess

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cursosandroidant.coupons.common.entities.CouponEntity

/****
 * Project: Coupons
 * From: com.cursosandroidant.coupons
 * Created by Alain Nicolás Tello on 23/02/22 at 19:18
 * All rights reserved 2022.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
@Dao
interface CouponDao {
 @Query("SELECT * FROM CouponEntity WHERE code = :code")
   suspend fun consultCouponByCode(code: String): CouponEntity?

   @Insert
   suspend fun addCoupon(couponEntity: CouponEntity): Long
}