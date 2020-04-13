package com.rusmyhal.fragmentfactoryexample

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var navigationListener: NavigationListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigationListener = try {
            context as NavigationListener
        } catch (e: ClassCastException) {
            throw RuntimeException("$context must implement ${NavigationListener::class.java}")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnOpenDetails.setOnClickListener {
            openDetails()
        }

        btnOpenDetailsArgs.setOnClickListener {
            val argString = textArgs.editText?.text.toString()
            val bundle = Bundle().apply {
                putString(DetailsFragment.EXTRA_ARGS, argString)
            }
            openDetails(bundle)
        }
    }

    override fun onDetach() {
        navigationListener = null
        super.onDetach()
    }

    private fun openDetails(args: Bundle? = null) {
        navigationListener?.navigateToDetails(args)
    }

    interface NavigationListener {

        fun navigateToDetails(args: Bundle?)
    }
}