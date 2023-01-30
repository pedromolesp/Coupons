package com.example.coupons.mainModule.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coupons.R
import com.example.coupons.common.entity.CouponEntity
import com.example.coupons.common.utils.getMessageErrorByCode
import com.example.coupons.mainModule.model.MainRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    private val result = MutableLiveData<CouponEntity>()
    fun getResult() = result
    private val coupon = MutableLiveData<CouponEntity>()

    private val hideKeyboard = MutableLiveData<Boolean>()
    fun getHideKeyboard() = hideKeyboard

    fun consultCouponByCodeOld(code: String) {
        viewModelScope.launch {
            result.value = repository.consultCouponByCode(code)
        }
    }

    private val snackMsg = MutableLiveData<Int>()
    fun getSnackbarMsg() = snackMsg

    fun consultCouponByCode() {
        coupon.value?.code.let { code ->
            viewModelScope.launch {
                hideKeyboard.value = true
                result.value = repository.consultCouponByCode(code)
            }
        }

    }

    fun saveCouponOld(couponEntity: CouponEntity) {
        viewModelScope.launch {

            try {
                repository.saveCoupon(couponEntity)
                consultCouponByCode()
                snackMsg.value = R.string.main_save_success
            } catch (e: Exception) {

                snackMsg.value = getMessageErrorByCode(e.message)
            }
        }
    }

    fun saveCoupon() {
        coupon.value?.let { couponEntity ->
            viewModelScope.launch {
                hideKeyboard.value = true
                try {
                    repository.saveCoupon(couponEntity)
                    consultCouponByCode()
                    snackMsg.value = R.string.main_save_success
                } catch (e: Exception) {

                    snackMsg.value = getMessageErrorByCode(e.message)
                }
            }
        }
    }
}