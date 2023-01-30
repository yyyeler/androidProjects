package yyy.myappcompany.guesswhat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_login.view.*


class loginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val fragment = inflater.inflate(R.layout.fragment_login, container, false)

        fragment.btStart.setOnClickListener()
        {
            Navigation.findNavController(it).navigate(R.id.toGameFrag)
        }

        return fragment
    }
}