package com.roshan.week6.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.roshan.week6.MainActivity.Companion.st
import com.roshan.week6.R
import com.roshan.week6.ui.ContactsAdapter
import com.roshan.week6.ui.contacts.Contacts


class HomeFragment : Fragment() {
    private lateinit var recycleview: RecyclerView
    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        recycleview = view.findViewById(R.id.recycleview)
        if (st.isEmpty()) {
            st.add(Contacts("Roshan Budhathoki", "Lazimpat", "Male", "22"))
            st.add(Contacts("Rabin Shrestha", "Baluwatar", "Male", "22"))
            var contactsAdapter = ContactsAdapter(context!!, st)
            recycleview.layoutManager = LinearLayoutManager(context)
            recycleview.adapter = contactsAdapter
        } else {
            var contactsAdapter1 = ContactsAdapter(context!!, st)
            recycleview.layoutManager = LinearLayoutManager(context)
            recycleview.adapter = contactsAdapter1
        }
        return view
    }
}


