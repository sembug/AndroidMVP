package sample.roberton.com.mvpusers.users.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_users.*
import kotlinx.android.synthetic.main.content_users.*
import sample.roberton.com.mvpusers.R
import sample.roberton.com.mvpusers.users.create.views.CreateUserActivity
import sample.roberton.com.mvpusers.users.model.User


class UsersActivity : Activity() {

    private lateinit var usersAdapter: UsersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        title = "Users"

//        usersAdapter = UsersAdapter(mutableListOf<User>(), { user : User -> OnClick(user) })
//        list_user.adapter = usersAdapter

        list_user.adapter = UsersAdapter(mutableListOf<User>()) { OnClick(it) }

        fab.setOnClickListener { _ ->
            val intent = Intent(this, CreateUserActivity::class.java)
            startActivityForResult(intent, CREATE_USER)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        if (requestCode == CREATE_USER && resultCode == Activity.RESULT_OK) {
            val user = data.getParcelableExtra<User>(USER_KEY)
            usersAdapter.addUser(user)
        }
    }

    fun OnClick(user: User) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(USER_KEY, user)
        startActivity(intent)
    }

    companion object {

        val USER_KEY = "user"
        val CREATE_USER = 1
    }
}
