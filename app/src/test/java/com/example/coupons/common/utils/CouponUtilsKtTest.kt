package com.example.coupons.common.utils

import com.cursosandroidant.coupons.common.utils.validateTextCode
import com.cursosandroidant.coupons.R
import com.cursosandroidant.coupons.common.utils.getMsgErrorByCode
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

    @Test
    fun validateTextCodeMinLengthTest() {
        val code = "HOLA"
        val code2 = "HOLA2"
        assertFalse(validateTextCode(code))
        assertTrue(validateTextCode(code2))
    }

    @Test
    fun validateTextCodeMaxLengthTest() {
        val code = "HOLA1234567"
        val code2 = "HOLA21234"
        assertFalse(validateTextCode(code))
        assertTrue(validateTextCode(code2))
    }

    @Test
    fun getMsgErrorByCodeNullTest(){
        val errorCode = null
        val expectedValue = R.string.error_unknow
        val result = getMsgErrorByCode(errorCode)
        assertEquals(expectedValue, result)
    }
}