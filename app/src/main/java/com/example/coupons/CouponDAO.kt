package com.example.coupons

import androidx.room.Insert
import androidx.room.Query

interface CouponDAO {
    @Query("SELECT * FROM CouponEntity WHERE code = :code")
    suspend fun consultCouponByCode(code:String): CouponEntity?

    @Insert
    suspend fun addCoupon(couponEntity: CouponEntity): Long

}