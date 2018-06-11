package sample.roberton.com.mvpusers.users.ui

import android.app.Activity
import android.os.Bundle
import sample.roberton.com.mvpusers.R
import sample.roberton.com.mvpusers.users.model.User
import kotlinx.android.synthetic.main.activity_detail.*
import sample.roberton.com.mvpusers.users.ui.UsersActivity

class DetailsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        title = "User"

        val user = intent.getParcelableExtra<User>(UsersActivity.USER_KEY)
        bindView(user)
    }

    private fun bindView(user: User) {
        first_name.text = user.firstName
        last_name.text = user.lastName
        rg.text = user.rg
        cpf.text = user.cpf
        email.text = user.email
    }
}