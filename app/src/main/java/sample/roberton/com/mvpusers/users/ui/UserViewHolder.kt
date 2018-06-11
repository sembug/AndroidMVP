package sample.roberton.com.mvpusers.users.ui

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.user_row.view.*
import sample.roberton.com.mvpusers.users.model.User

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(user: User, listener: (User) -> Unit) = with(itemView) {
        user_name.text = user.firstName
        setOnClickListener { listener(user) }
    }
}