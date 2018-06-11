package sample.roberton.com.mvpusers.users.ui;

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import sample.roberton.com.mvpusers.R
import sample.roberton.com.mvpusers.users.model.User
import sample.roberton.com.mvpusers.inflate

class UsersAdapter(var users: MutableList<User>, val listener: (User) -> Unit):
    RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        return UserViewHolder(parent.inflate(R.layout.user_row))
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int ) {
        holder.bind(users[position], listener)
    }

    override fun getItemCount() = users.size

    fun addUser(user: User?) {
        users.add(user!!)
        notifyDataSetChanged()
    }

    interface UserClickListener {
        fun onClick(user: User)
    }
}

