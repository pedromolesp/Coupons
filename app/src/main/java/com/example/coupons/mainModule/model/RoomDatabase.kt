package com.cursosandroidant.coupons.mainModule.model

import android.database.sqlite.SQLiteConstraintException
import com.cursosandroidant.coupons.CouponsApplication
import com.cursosandroidant.coupons.common.dataAccess.CouponDao
import com.cursosandroidant.coupons.common.entities.CouponEntity
import com.cursosandroidant.coupons.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

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
class RoomDatabase {
    private val dao: CouponDao by lazy { CouponsApplication.database.couponDao() }

    suspend fun consultCouponByCode(code: String) = dao.consultCouponByCode(code)

    suspend fun saveCoupon(couponEntity: CouponEntity) = withContext(Dispatchers.IO){
        try {
            dao.addCoupon(couponEntity)
        } catch (e: Exception){
            (e as? SQLiteConstraintException)?.let { throw Exception(Constants.ERROR_EXIST) }
            throw Exception(e.message ?: Constants.ERROR_UNKNOW)
        }
    }
}