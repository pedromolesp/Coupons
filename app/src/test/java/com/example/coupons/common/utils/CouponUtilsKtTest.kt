package com.example.coupons.common.utils

import com.cursosandroidant.coupons.common.utils.validateTextCode
import org.junit.Assert.*
import org.junit.Test

class CouponUtilsKtTest {
    @Test
    fun validateTextCodeSuccessTest() {
        val code = "WELCOME"
        assertTrue(validateTextCode(code))
    }
    @Test
    fun validateTextCodeEmptyFailTest() {
        val code = ""
        assertFalse(validateTextCode(code))
    }
}