package com.example.propertywatch

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.propertywatch.data.Property
import loadData
import java.io.ByteArrayOutputStream
import kotlin.random.Random

class listFragment : Fragment(R.layout.list_page_fragment), PropertyListRecycleViewAdapter.OnItemClickListener{

    private lateinit var recyclerView : RecyclerView;

    //An arraylist to store all the property classes, which will be generated from R.String array
    var propertyList: ArrayList<Property> = loadData();

    //Adapter for recycler view
    lateinit var adapter:PropertyListRecycleViewAdapter;

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view : View = inflater.inflate(R.layout.list_page_fragment, container, false)
        recyclerView=view.findViewById(R.id.mRecyclerView);
        recyclerView.setHasFixedSize(true);
        adapter= PropertyListRecycleViewAdapter( inflaterr = inflater, propertyList = propertyList, this);
        recyclerView.adapter=adapter;
        recyclerView.layoutManager=LinearLayoutManager(context);
        return view ;
    }

    //On list item click
    override fun onItemClick(postion: Int) {
        val selectedProperty = propertyList[postion];

        val intent = Intent (activity, MapsActivity::class.java)
        intent.putExtra("position", postion);
        activity?.startActivity(intent)
    }
}