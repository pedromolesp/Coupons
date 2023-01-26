package com.example.coupons.mainModule.model

import android.database.sqlite.SQLiteConstraintException
import com.example.coupons.CouponApplication
import com.example.coupons.common.dataAccess.CouponDAO
import com.example.coupons.common.entity.CouponEntity
import com.example.coupons.common.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomDatabase {
    private val dao: CouponDAO by lazy { CouponApplication.database.couponDao() }

    suspend fun consultCouponByCode(code: String) = dao.consultCouponByCode(code)

    suspend fun saveCoupon(couponEntity: CouponEntity) = withContext(Dispatchers.IO) {
        try {
            dao.addCoupon(couponEntity)
        } catch (e: Exception) {
            (e as? SQLiteConstraintException)?.let {
                throw Exception(Constants.ERROR_EXIST)
            }
            throw Exception(e.message ?: Constants.ERROR_UNKNOWN)
        }
    }
}