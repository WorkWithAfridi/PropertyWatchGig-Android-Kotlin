package com.example.propertywatch

import android.content.Context
import android.content.Intent
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.propertywatch.data.Property

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
        holder.properyPriceTextViewInViewHolder.text="$"+propertyList.get(position).price.toString()
    }


    override fun getItemCount(): Int {
        return  propertyList.size;
    }

    class ViewHolder(ItemView: View, var listenerr: OnItemClickListener) : RecyclerView.ViewHolder(ItemView) ,
    View.OnClickListener{
        val properyAddressTextViewInViewHolder: TextView = itemView.findViewById(R.id.propertyNameTextView)
        val properyPriceTextViewInViewHolder: TextView = itemView.findViewById(R.id.propertyPriceTextView)

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

    // On send Email button click, this function is initiated
    fun sendEmail(view: View) {
//        var shelterName: EditText =findViewById(R.id.shelterName)
//        val shelterEmail: EditText =findViewById(R.id.shelterEmail)
//        //if the shelter name and the shelter email edittext is not empty, then initiate the if part, else go on with the else part.
//        //after the variables are checked, the necessary datas are extracted and passed on to a new intent which opens ip the default mailing app and
//        //fills the recipient, subject and body of the email and awaits for user confirmation.
//        //after the user confirms and email is send to the shelter
//        if(!TextUtils.isEmpty(shelterName.text.toString()) && !TextUtils.isEmpty(shelterEmail.text.toString()) ){
//            val intent = Intent(Intent.ACTION_SEND)
//            val recipients = arrayOf(shelterEmail.text.toString())
//            intent.putExtra(Intent.EXTRA_EMAIL, recipients)
//            intent.putExtra(Intent.EXTRA_SUBJECT, "Accommodation Request")
//            var name = shelterName.text.toString()
//            intent.putExtra(Intent.EXTRA_TEXT, "I would like to request accommodation for tonight at $name")
//            intent.putExtra(Intent.EXTRA_CC, "mailcc@gmail.com")
//            intent.type = "text/html"
//            intent.setPackage("com.google.android.gm")
//            startActivity(Intent.createChooser(intent, "Send mail"))
//        }
//        else{
//            //continue //do Nothing
//        }
    }
}