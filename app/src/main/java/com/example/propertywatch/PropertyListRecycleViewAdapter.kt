package com.example.propertywatch

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.propertywatch.database.Property


class PropertyListRecycleViewAdapter(var inflaterr: LayoutInflater, var propertyList: ArrayList<Property>, val listener: OnItemClickListener) : RecyclerView.Adapter<PropertyListRecycleViewAdapter.ViewHolder>() {



    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PropertyListRecycleViewAdapter.ViewHolder {
//        var inflater : LayoutInflater = LayoutInflater.from(context);
        var inflater : LayoutInflater = inflaterr;
        var view : View = inflater.inflate(R.layout.recycler_view_row, parent, false);

        return PropertyListRecycleViewAdapter.ViewHolder(view, listener);
    }

    override fun onBindViewHolder(
        holder: PropertyListRecycleViewAdapter.ViewHolder,
        position: Int
    ) {
        holder.properyAddressTextViewInViewHolder.text=propertyList.get(position).address;
        holder.properyPriceTextViewInViewHolder.text="Price: $"+propertyList.get(position).price.toString()
        holder.propertyPhoneTextViewViewHolder.text="Phone: "+propertyList.get(position).phone.toString()
        holder.emailButton.setOnClickListener(){
            val selectedProperty = propertyList[position];

            val intent = Intent(Intent.ACTION_SEND)
            val recipients = arrayOf("ayon.tonmoy01@gmail.com")

            intent.putExtra(Intent.EXTRA_EMAIL, recipients)
            intent.putExtra(Intent.EXTRA_SUBJECT, "Investment Property Advice")
            intent.putExtra(Intent.EXTRA_TEXT, "I would like to recommend this property at ${selectedProperty.address} listed for ${selectedProperty.price}")
            intent.putExtra(Intent.EXTRA_CC, "mailcc@gmail.com")
            intent.type = "text/html"
            intent.setPackage("com.google.android.gm")
            startActivity(inflaterr.context, intent, Bundle.EMPTY)
        }
    }


    override fun getItemCount(): Int {
        return  propertyList.size;
    }

    class ViewHolder(ItemView: View, var listenerr: OnItemClickListener) : RecyclerView.ViewHolder(ItemView) ,
    View.OnClickListener{
        val properyAddressTextViewInViewHolder: TextView = itemView.findViewById(R.id.propertyNameTextView)
        val properyPriceTextViewInViewHolder: TextView = itemView.findViewById(R.id.propertyPriceTextView)
        val propertyPhoneTextViewViewHolder: TextView = itemView.findViewById(R.id.propertyPhoneTextView)
        val emailButton: Button = itemView.findViewById(R.id.emailButton)

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val postion: Int= adapterPosition;
            if(postion!=RecyclerView.NO_POSITION){
                listenerr.onItemClick(postion);
            }
        }
    }

    interface OnItemClickListener{
        fun onItemClick(postion: Int);
    }
}