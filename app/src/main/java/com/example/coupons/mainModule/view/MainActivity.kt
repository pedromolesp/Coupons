package com.example.coupons.mainModule.view

import android.content.res.Resources.Theme
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.coupons.BR
import com.example.coupons.R
import com.example.coupons.common.utils.hideKeyboard
import com.example.coupons.databinding.ActivityMainBinding
import com.example.coupons.mainModule.viewmodel.MainViewModel
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setupViewModel()
        setupObservers()
    }


    private fun setupObservers() {
        binding.viewModel?.let {
            it.coupon.observe(this@MainActivity) { coupon ->
                binding.isActive = coupon != null && coupon.isActive
                if (coupon.isActive){
                    binding.tvTtitle.text = "Cupón disponible, añade descripción y pulsa crear"
                    binding.tvTtitle.setTextColor(resources.getColor(androidx.media.R.color.secondary_text_default_material_dark))
                }else{
                    binding.tvTtitle.text = resources.getString(R.string.title)

                }
                it.getSnackbarMsg().observe(this@MainActivity) { msg ->
                    Snackbar.make(binding.root, msg, Snackbar.LENGTH_SHORT).show()
                }
                it.isHideKeyboard().observe(this@MainActivity) { isHidden ->
                    if (isHidden) hideKeyboard(this@MainActivity, binding.root)
                }
            }
        }


    }

    private fun setupViewModel() {
        val vm: MainViewModel by viewModels()
        binding.lifecycleOwner = this
        binding.setVariable(BR.viewModel, vm)
    }
}