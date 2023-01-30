package yyy.myappcompany.getmovie

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter (private val mContext : Context,private val movieList : List<Movies>) : RecyclerView.Adapter<RVAdapter.cardViewDesignObjectHolder>()
{

    inner class cardViewDesignObjectHolder(view : View) : RecyclerView.ViewHolder(view)
    {

        var cardView : CardView;
        var imageView : ImageView;
        var tvName : TextView;
        var tvPrice : TextView;
        var btAdd : Button;

        init
        {
            cardView = view.findViewById(R.id.cardView)
            imageView = view.findViewById(R.id.imageView)
            tvName = view.findViewById(R.id.tvName)
            tvPrice = view.findViewById(R.id.tvPrice)
            btAdd = view.findViewById(R.id.btAdd)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): cardViewDesignObjectHolder {
        val design = LayoutInflater.from(mContext).inflate(R.layout.cardview,parent,false)
        return cardViewDesignObjectHolder(design)
    }

    override fun onBindViewHolder(holder: cardViewDesignObjectHolder, position: Int) {
        val movie = movieList[position]

        holder.tvName.text = movie.movieName
        holder.tvPrice.text = movie.moviePrice + " TL"

        holder.imageView.setImageResource(mContext.resources.getIdentifier(movie.movieFileName,"drawable",mContext.packageName))

        holder.btAdd.setOnClickListener{ item ->
            Toast.makeText(mContext,movie.movieName+" is added in your cart",Toast.LENGTH_SHORT).show()
        }



    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}