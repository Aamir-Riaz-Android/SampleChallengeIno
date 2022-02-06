package com.example.samplechallengeino.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.samplechallengeino.R
import com.example.samplechallengeino.base.BaseFragment
import com.example.samplechallengeino.data.parsing.ContentState
import com.example.samplechallengeino.data.parsing.ErrorState
import com.example.samplechallengeino.data.parsing.LoadingState
import com.example.samplechallengeino.data.parsing.UiState
import com.example.samplechallengeino.databinding.FragmentLoginBinding
import com.example.samplechallengeino.ui.activities.MainActivity
import com.example.samplechallengeino.utils.Constants
import com.example.samplechallengeino.utils.isNetworkAvailable
import com.example.samplechallengeino.viewmodel.ItemsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : BaseFragment<FragmentLoginBinding>(FragmentLoginBinding::inflate) {
    private val viewModel:ItemsViewModel  by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
            with(  (activity as MainActivity)) {
                binding?.tvHeading1?.text = "IS Test Project"
                binding?.tvHeading2?.visibility=View.GONE
            }
        viewModel._uiState.observe(this, uiStateObserver)

        binding?.btnLogin?.setOnClickListener {
            // i am not checking for validity like user inputs ,just login in  with the test credentials
            (activity as MainActivity).apply {
                if(!(isNetworkAvailable<MainActivity>())) makeToast(getString(R.string.no_internet_error))
                else viewModel.getLoggedin()
            }
        }
    }
    private val uiStateObserver = Observer<UiState> {
        when (it) {
            LoadingState -> binding?.progressCircular?.visibility=View.VISIBLE
            ContentState -> {
                binding?.progressCircular?.visibility=View.GONE
                //move to the next screen
                (activity as MainActivity).navigateTo(
                    R.id.action_loginFragment_to_welcomeFragment2,"test1"//just adding it dummy will update it for security reasons if its private api

                )
            }
            ErrorState ->{
                binding?.progressCircular?.visibility=View.GONE
                makeToast(getString(R.string.something_went_wrong))
            }
        }
    }

}