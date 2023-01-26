package com.example.coupons.mainModule.model

import com.example.coupons.common.entity.CouponEntity
import com.example.coupons.common.utils.Constants
import com.example.coupons.common.utils.validateText

class MainRepository {

    private val roomDatabase = RoomDatabase()

    suspend fun consultCouponByCode(code: String) = roomDatabase.consultCouponByCode(code)
    suspend fun saveCoupon(couponEntity: CouponEntity) {
        if (validateText(couponEntity.code)) {
            roomDatabase.saveCoupon(couponEntity)
        } else {
            throw Exception(Constants.ERROR_LENGTH)
        }
    }
}