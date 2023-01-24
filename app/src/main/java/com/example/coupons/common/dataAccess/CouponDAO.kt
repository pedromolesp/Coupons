package com.example.coupons.common.dataAccess

import androidx.room.Insert
import androidx.room.Query
import com.example.coupons.common.entity.CouponEntity

interface CouponDAO {
    @Query("SELECT * FROM CouponEntity WHERE code = :code")
    suspend fun consultCouponByCode(code:String): CouponEntity?

    @Insert
    suspend fun addCoupon(couponEntity: CouponEntity): Long

}