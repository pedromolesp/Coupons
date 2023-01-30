package com.example.coupons.mainModule.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.coupons.common.entity.CouponEntity
import com.example.coupons.common.utils.hideKeyboard
import com.example.coupons.databinding.ActivityMainBinding
import com.example.coupons.mainModule.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
        setupObservers()
        setupButtons()
    }

    private fun setupButtons() {
        binding.btnConsult.setOnClickListener {
//            mainViewModel.consultCouponByCode(binding.etCoupon.text.toString())
            hideKeyboard(this, binding.root)
        }
        binding.btnCreate.setOnClickListener {
            val coupon = CouponEntity(
                code = binding.etCoupon.text.toString(),
                description = binding.etDescription.text.toString()
            )
//            mainViewModel.saveCoupon(coupon)
            hideKeyboard(this, binding.root)

        }
    }

    private fun setupObservers() {
//        mainViewModel.getResult().observe(this) { coupon ->
//            if (coupon == null) {
//                binding.tilDescriptiom.hint = getString(R.string.main_hint_description)
//                binding.tilDescriptiom.isEnabled = true
//                binding.btnCreate.visibility = View.VISIBLE
//            } else {
//                binding.etDescription.setText(coupon.description)
//                val status =
//                    getString(if (coupon.isActive) R.string.main_hint_active else R.string.main_hint_inactive)
//                binding.tilDescriptiom.hint = status
//                binding.tilDescriptiom.isEnabled = false
//                binding.btnCreate.visibility = if (coupon.isActive) View.GONE else View.VISIBLE
//            }
//        }
        mainViewModel.getSnackbarMsg().observe(this) { msg ->
            Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun setupViewModel() {
        mainViewModel = ViewModelProvider(this)[MainViewModel::class.java]

    }
}