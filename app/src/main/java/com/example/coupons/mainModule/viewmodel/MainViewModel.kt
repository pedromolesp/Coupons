package com.cursosandroidant.coupons.mainModule.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cursosandroidant.coupons.R
import com.cursosandroidant.coupons.common.entities.CouponEntity
import com.cursosandroidant.coupons.common.utils.getMsgErrorByCode
import com.cursosandroidant.coupons.mainModule.model.MainRepository
import kotlinx.coroutines.launch

/****
 * Project: Coupons
 * From: com.cursosandroidant.coupons.mainModule.viewModel
 * Created by Alain Nicolás Tello on 24/02/22 at 13:59
 * All rights reserved 2022.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    val coupon = MutableLiveData(CouponEntity())

    private val hideKeyboard = MutableLiveData<Boolean>()
    fun isHideKeyboard() = hideKeyboard

    private val snackbarMsg = MutableLiveData<Int>()
    fun getSnackbarMsg() = snackbarMsg

    fun consultCouponByCode(){
        coupon.value?.code?.let { code ->
            viewModelScope.launch {
                hideKeyboard.value = true
                coupon.value = repository.consultCouponByCode(code) ?: CouponEntity(code = code, isActive = false)
            }
        }
    }

    fun saveCoupon(){
        coupon.value?.let { couponEntity ->
            viewModelScope.launch {
                hideKeyboard.value = true
                try {
                    couponEntity.isActive = true
                    repository.saveCoupon(couponEntity)
                    consultCouponByCode()
                    snackbarMsg.value = R.string.main_save_success
                } catch (e: Exception) {
                    snackbarMsg.value = getMsgErrorByCode(e.message)
                }
            }
        }
    }
}