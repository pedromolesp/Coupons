package com.example.coupons.common.utils

import com.cursosandroidant.coupons.common.utils.validateTextCode
import com.cursosandroidant.coupons.R
import com.cursosandroidant.coupons.common.utils.Constants
import com.cursosandroidant.coupons.common.utils.getMsgErrorByCode
import com.example.coupons.common.entity.CouponEntity
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
        assertEquals("Error al evaluar un null",expectedValue, result)
    }

    @Test
    fun getMsgErrorByCodeExistTest(){
        val errorCode = Constants.ERROR_EXIST
        val expectedValue = R.string.error_unique_code
        val result = getMsgErrorByCode(errorCode)
        assertEquals("Error al evaluar un cupón existente",expectedValue, result)
    }
    @Test
    fun getMsgErrorByCodeLengthTest(){
        val errorCode = Constants.ERROR_LENGTH
        val expectedValue = R.string.error_invalid_length
        val result = getMsgErrorByCode(errorCode)
        assertEquals("Error al evaluar la longitud válida",expectedValue, result)
        assertNotEquals("El recurso no existe",-1, result)
    }

    @Test
    fun checkNotNullCouponTest(){
        val coupon = CouponEntity(code = "ANDROID", description = "Cursos a $9,99 USD")
        assertNotNull(coupon)
    }
}