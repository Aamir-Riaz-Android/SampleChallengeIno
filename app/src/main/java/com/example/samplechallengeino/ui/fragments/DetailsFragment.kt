package com.example.samplechallengeino.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.samplechallengeino.R
import com.example.samplechallengeino.adapters.ItemListAdapter
import com.example.samplechallengeino.base.BaseFragment
import com.example.samplechallengeino.data.parsing.ContentState
import com.example.samplechallengeino.data.parsing.ErrorState
import com.example.samplechallengeino.data.parsing.LoadingState
import com.example.samplechallengeino.data.parsing.UiState
import com.example.samplechallengeino.databinding.FragmentDetailsBinding
import com.example.samplechallengeino.ui.activities.MainActivity
import com.example.samplechallengeino.utils.isNetworkAvailable
import com.example.samplechallengeino.viewmodel.ItemsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate) {
    @Inject
    lateinit var itemsListAdapter: ItemListAdapter

    private val viewModel: ItemsViewModel by activityViewModels()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(  (activity as MainActivity)) {
            binding?.tvHeading1?.text = "Details of list items"
            binding?.tvHeading2?.visibility=View.GONE
        }
        binding?.rvList?.adapter = itemsListAdapter
        viewModel._uiState.observe(this, uiStateObserver)
        (activity as MainActivity).apply {
            if (!(isNetworkAvailable<MainActivity>())) makeToast(getString(R.string.no_internet_error))
            else viewModel.getDataFromRemoteSource()
        }

        viewModel._itemDetailsList.observe(this, Observer {
            itemsListAdapter.setItemList(it.itemList)
        })
    }

    private val uiStateObserver = Observer<UiState> {
        when (it) {
            LoadingState -> binding?.progressCircular?.visibility = View.VISIBLE
            ContentState -> {
                binding?.progressCircular?.visibility = View.GONE
            }
            ErrorState -> {
                binding?.progressCircular?.visibility = View.GONE
                makeToast(getString(R.string.something_went_wrong))
            }
        }
    }


}