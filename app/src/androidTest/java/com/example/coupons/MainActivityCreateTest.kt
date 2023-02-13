package com.example.coupons

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.cursosandroidant.coupons.mainModule.view.MainActivity
import org.junit.Rule
import org.junit.runner.RunWith
import com.cursosandroidant.coupons.R
import org.junit.Test


@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityCreateTest {
    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun createCouponTest(){
        val etCoupon = onView(withId(R.id.etCoupon))
        etCoupon.check(matches(withText("")))
    }
}