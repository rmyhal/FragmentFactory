package com.rusmyhal.fragmentfactoryexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment(private val viewModel: DetailsViewModel) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val myArgs = arguments?.getString(EXTRA_ARGS)
        val text = viewModel.getHello() + myArgs.orEmpty()
        textView.text = text
    }

    companion object {

        const val TAG = "DetailsFragment"
        const val EXTRA_ARGS = "my_args"
    }
}