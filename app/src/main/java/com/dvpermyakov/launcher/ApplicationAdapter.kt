package com.dvpermyakov.launcher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.layout_application_item.view.*

class ApplicationAdapter : RecyclerView.Adapter<ApplicationAdapter.ViewHolder>() {

    var items = emptyList<ApplicationItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_application_item, parent, false)
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(override val containerView: View) :
        RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun bind(item: ApplicationItem) {
            containerView.nameView.text = item.name
            containerView.iconView.setImageDrawable(item.icon)

            containerView.containerView.setOnClickListener {
                if (item.intent != null) {
                    containerView.context.startActivity(item.intent)
                } else {
                    Toast.makeText(containerView.context, "Not found intent", Toast.LENGTH_LONG)
                        .show()
                }
            }
        }

    }
}