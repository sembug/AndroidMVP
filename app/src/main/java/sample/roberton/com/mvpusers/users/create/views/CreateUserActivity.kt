package sample.roberton.com.mvpusers.users.create.views

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_create_user.*
import kotlinx.android.synthetic.main.activity_login.*
import sample.roberton.com.mvpusers.R
import sample.roberton.com.mvpusers.users.model.User
import sample.roberton.com.mvpusers.users.create.presenter.CreateUserInteractorImpl
import sample.roberton.com.mvpusers.users.create.presenter.CreateUserPresenterImpl
import sample.roberton.com.mvpusers.users.ui.UsersActivity

class CreateUserActivity : Activity(), CreateUserView {

    private lateinit var presenter: CreateUserPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_user)
        title = "create_user"
        create_button.setOnClickListener { v: View -> onClick(v) }

        presenter = CreateUserPresenterImpl(this, CreateUserInteractorImpl())
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun navigateToHome(user: User) {
        val intentResult = Intent()
        intentResult.putExtra(UsersActivity.USER_KEY, user)
        setResult(Activity.RESULT_OK, intentResult)
        finish()
    }

    override fun isFormFilled(): Boolean {
        when {
            first_name.getText().toString().isEmpty() -> {
                first_name.error = getString(R.string.mandatory_text)
                return false
            }
            last_name.text.toString().isEmpty() -> {
                last_name.error = getString(R.string.mandatory_text)
                return false
            }
            rg.text.toString().isEmpty() -> {
                rg.error = getString(R.string.mandatory_text)
                return false
            }
            cpf.text.toString().isEmpty() -> {
                cpf.error = getString(R.string.mandatory_text)
                return false
            }
            email.text.toString().isEmpty() -> {
                email.error = getString(R.string.mandatory_text)
                return false
            }
            else -> return true
        }

    }

    fun onClick(v: View) {
        if (isFormFilled()) {
            val user = User()
            user.firstName = first_name.text.toString()
            user.lastName = last_name.text.toString()
            user.rg = rg.text.toString()
            user.cpf = cpf.text.toString()
            user.email = email.text.toString()

            navigateToHome(user)
        }
    }
}
