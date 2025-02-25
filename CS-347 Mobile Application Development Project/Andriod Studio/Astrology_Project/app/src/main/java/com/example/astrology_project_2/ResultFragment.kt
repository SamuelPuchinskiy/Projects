package com.example.astrology_project_2


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_result.*

/**
 * A simple [Fragment] subclass.
 */
class ResultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = getArguments()
        var strValue = args?.let { ResultFragmentArgs.fromBundle(it).valueStr }

        if(args != null)
        {
            val msg = "$strValue";
            valueStr.text = msg
        }
        else
        {
            val msg = "Unknown output. Please try again.";
            valueStr.text = msg
        }
    }
}
