package com.creyc.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerview_item.view.*


class PhoneAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.recyclerview_item, parent, false)
        return  PhonesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PhonesViewHolder) {
            holder.bind(mPhoneList[position])
        }
    }

    override fun getItemCount(): Int {
        return PhonesData.phonesArr.size
    }

    private var mPhoneList: ArrayList<PhoneModel> = ArrayList()

    fun setupPhones (phonesList: Array<PhoneModel>) {
        mPhoneList.clear()
        mPhoneList.addAll(phonesList)
        notifyDataSetChanged()
    }

    class PhonesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(nPhone: PhoneModel) {
            itemView.textViewName.text = nPhone.name
            itemView.textViewPrice.text = nPhone.price
            itemView.textViewDate.text = nPhone.date
            itemView.textViewScore.text = nPhone.score
        }
    }
}
