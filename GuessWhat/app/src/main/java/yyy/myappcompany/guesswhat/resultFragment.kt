package yyy.myappcompany.guesswhat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import kotlinx.android.synthetic.main.fragment_game.view.*
import kotlinx.android.synthetic.main.fragment_result.view.*

class resultFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragment = inflater.inflate(R.layout.fragment_result, container, false)
        val bundle:resultFragmentArgs by navArgs()

        val result = bundle.isWon

        if(result)
        {
            fragment.tvResult.text = "You Won"
            fragment.ivResult.setImageResource(R.drawable.winner)

        }
        else
        {
            fragment.tvResult.text = "You Lost"
            fragment.ivResult.setImageResource(R.drawable.lose)
        }

        fragment.btRetry.setOnClickListener()
        {
            Navigation.findNavController(it).navigate(R.id.resToGame)
        }

        return fragment
    }

}