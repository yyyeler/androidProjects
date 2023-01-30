package yyy.myappcompany.guesswhat

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_game.view.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.fragment_result.*
import kotlin.random.Random

class gameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragment = inflater.inflate(R.layout.fragment_game, container, false)

        fragment.numberPicker.minValue = 1
        fragment.numberPicker.maxValue = 100



        val randomNumber = Random.nextInt(1,100)
        Log.e("RandomValue",randomNumber.toString())
        var counter = 5

        fragment.btGuess.setOnClickListener()
        {
            val value = fragment.numberPicker.value.toString()

            if(value.toInt() == randomNumber)
            {
                Log.e("result","You Won")
                val transition = gameFragmentDirections.toResultFrag(true)
                Navigation.findNavController(it).navigate(transition)
            }
            else if(value.toInt() > randomNumber)
            {
                fragment.tvUpandDown.text = "Go Down!"
                Log.e("answer","wrong")
                counter--
            }
            else
            {
                fragment.tvUpandDown.text = "Go Up!"
                Log.e("answer","wrong")
                counter--
            }

            if(counter == 0)
            {
                Log.e("result","You Lost")
                val transition = gameFragmentDirections.toResultFrag(false)
                Navigation.findNavController(it).navigate(transition)
            }

            tvRemain.text = "Remain Guess : $counter"
        }

        return fragment

    }

}