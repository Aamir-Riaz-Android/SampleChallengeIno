package com.example.samplechallengeino.ui.activities

import android.os.Bundle
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.samplechallengeino.R
import com.example.samplechallengeino.base.BaseActivity
import com.example.samplechallengeino.databinding.ActivityMainBinding
import com.example.samplechallengeino.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.user_nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
    }

    fun navigateTo(id: Int) = navController.navigate(id)
    fun navigateTo(id: Int,userName:String) {
        val bundle = bundleOf(Constants.USER_NAME_KEY to userName)
        navController.navigate(id,bundle)
    }
}