package com.example.coupons.mainModule.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coupons.R
import com.example.coupons.common.entity.CouponEntity
import com.example.coupons.common.utils.getMessageErrorByCode
import com.example.coupons.mainModule.model.MainRepository
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    private val result = MutableLiveData<CouponEntity>()
    fun getResult() = result

    private val snackMsg = MutableLiveData<Int>()
    fun getSnackbarMsg() = snackMsg

    fun consultCouponByCode(code: String) {
        viewModelScope.launch {
            result.value = repository.consultCouponByCode(code)
        }
    }

    fun saveCoupon(couponEntity: CouponEntity) {
        viewModelScope.launch {

            try {
                repository.saveCoupon(couponEntity)
                consultCouponByCode(couponEntity.code)
                snackMsg.value = R.string.main_save_success
            } catch (e: Exception) {

                snackMsg.value = getMessageErrorByCode(e.message)
            }
        }
    }
}