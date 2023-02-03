package com.cursosandroidant.coupons.common.entities

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

/****
 * Project: Coupons
 * From: com.cursosandroidant.coupons
 * Created by Alain Nicolás Tello on 23/02/22 at 19:14
 * All rights reserved 2022.
 *
 * All my Udemy Courses:
 * https://www.udemy.com/user/alain-nicolas-tello/
 * Web: www.alainnicolastello.com
 ***/
@Entity(tableName = "CouponEntity", indices = [Index(value = ["code"], unique = true)])
data class CouponEntity(@PrimaryKey(autoGenerate = true) var id: Long = 0,
                        var code: String = "",
                        var description: String = "",
                        var isActive: Boolean = true)
