package com.example.samplechallengeino.ui.fragments

import android.os.Bundle
import android.view.View
import com.example.samplechallengeino.R
import com.example.samplechallengeino.base.BaseFragment
import com.example.samplechallengeino.databinding.FragmentWelcomeBinding
import com.example.samplechallengeino.ui.activities.MainActivity
import com.example.samplechallengeino.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(FragmentWelcomeBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        arguments?.getString(Constants.USER_NAME_KEY)?.let {
            with((activity as MainActivity)) {
                binding?.tvHeading1?.text = "Welcome"
                binding?.tvHeading2?.text = it
                binding?.tvHeading2?.visibility = View.VISIBLE
            }

        }

        binding?.btnViewDetails?.setOnClickListener {
            (activity as MainActivity).navigateTo(
                R.id.action_welcomeFragment2_to_detailsFragment
            )
        }
    }

}