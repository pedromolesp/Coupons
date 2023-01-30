package com.example.coupons.common.utils

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.example.coupons.R

fun validateText(code: String): Boolean {
    return !(code.length < 5 || code.length > 10)
}

fun getMessageErrorByCode(errorCode: String?): Int = when (errorCode) {
    Constants.ERROR_EXIST -> (R.string.exist)
    Constants.ERROR_LENGTH -> (R.string.length)
    Constants.ERROR_EXIST -> (R.string.unknown)
    else -> R.string.unknown
}

fun hideKeyboard(context: Context, view: View) {
    val im = context.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    im?.hideSoftInputFromWindow(view.windowToken, 0)
}