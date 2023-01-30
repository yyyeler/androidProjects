package yyy.myappcompany.getmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var movieList : ArrayList<Movies>
    private lateinit var adapter : RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv.setHasFixedSize(true)
        rv.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        val m1 = Movies(1,"Artemis Fowl","artemis","50.00");
        val m2 = Movies(2,"Avatar","avatar","70.00");
        val m3 = Movies(3,"Black Adam","blackadam","60.00");
        val m4 = Movies(4,"Karakomik 2","karakomik","30.00");
        val m5 = Movies(5,"Suicide Squad","ssquad","35.00");
        val m6 = Movies(6,"Uncharted","uncharted","40.00");

        movieList = ArrayList<Movies>()
        movieList.add(m1);
        movieList.add(m2);
        movieList.add(m3);
        movieList.add(m4);
        movieList.add(m5);
        movieList.add(m6);

        adapter = RVAdapter(this@MainActivity,movieList)
        rv.adapter = adapter

    }
}