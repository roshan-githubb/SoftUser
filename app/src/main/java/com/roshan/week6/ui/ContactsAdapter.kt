package com.roshan.week6.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.roshan.week6.R
import com.roshan.week6.ui.contacts.Contacts

class ContactsAdapter( mContext: Context, contactsList:MutableList<Contacts>):
        RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {
    var contactsList=contactsList
    var mContext=mContext

    init {
        this.mContext = mContext
        this.contactsList = contactsList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactsViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_contact, parent, false)
        return ContactsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        var contacts = contactsList[position]
        holder.stfullname.text = contacts.getName()
        holder.st_age.text = contacts.getAge()
        holder.staddress.text = contacts.getAddress()
        holder.stgender.text = contacts.getGender()
        //        holder.delete.setImageResource(R.drawable.ic_delete);
        holder.stimage.setImageDrawable(mContext.getDrawable(R.drawable.ic_delete_black_24dp))
        val gen = contacts.getGender()
        if (gen === "Male") {
            holder.stimage.setImageResource(R.drawable.male)
            //            holder.imageview.setImageDrawable(mContext.getResources().getDrawable(R.drawable.man));
        } else if (gen === "Female") {
            holder.stimage.setImageDrawable(mContext.getDrawable(R.drawable.female))
        } else {
            holder.stimage.setImageDrawable(mContext.getDrawable(R.drawable.female))
        }
        holder.stimage.setOnClickListener { Toast.makeText(mContext, "Hey " + contacts.getName(), Toast.LENGTH_SHORT).show() }
        holder.stdelete.setOnClickListener {
            val cn = contactsList[position]

            // Remove the item on remove/button click
            contactsList.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position, contactsList.size)

            // Show the removed item label
            Toast.makeText(mContext, "Removed : " + cn.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return contactsList.size
    }

    inner class ContactsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var stimage: ImageView
        var stdelete: ImageView
        var stfullname: TextView
        var st_age: TextView
        var staddress: TextView
        var stgender: TextView

        init {
            stimage = itemView.findViewById(R.id.stimage)
            stfullname = itemView.findViewById(R.id.stfullname)
            st_age = itemView.findViewById(R.id.st_age)
            staddress = itemView.findViewById(R.id.staddress)
            stgender = itemView.findViewById(R.id.stgender)
            stdelete = itemView.findViewById(R.id.stdelete)
        }
    }

    //constructor to receive data from the activity





}



