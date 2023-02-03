package com.cursosandroidant.coupons.mainModule.model

import com.cursosandroidant.coupons.common.entities.CouponEntity
import com.cursosandroidant.coupons.common.utils.Constants
import com.cursosandroidant.coupons.common.utils.validateTextCode

/****
 * Project: Coupons
 * From: com.cursosandroidant.coupons.mainModule.model
 * Created by Alain Nicolás Tello on 24/02/22 at 13:58
 * All rights reserved 2022.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class MainRepository {
    private val roomDatabase = RoomDatabase()

    suspend fun consultCouponByCode(code: String) = roomDatabase.consultCouponByCode(code)

    suspend fun saveCoupon(couponEntity: CouponEntity){
        if (validateTextCode(couponEntity.code)){
            roomDatabase.saveCoupon(couponEntity)
        } else {
            throw Exception(Constants.ERROR_LENGTH)
        }
    }
}