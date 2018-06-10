package sample.roberton.com.mvpusers.login

import android.app.Activity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*
import sample.roberton.com.mvpusers.R

class LoginActivity : Activity(), LoginView, View.OnClickListener {

    private lateinit var presenter: LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        button.setOnClickListener(this)

        presenter = LoginPresenterImpl(this, LoginInteractorImpl())
    }

    override fun onDestroy() {
        presenter!!.onDestroy()
        super.onDestroy()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
    }

    override fun setUsernameError() {
        username.error = getString(R.string.username_error)
    }

    override fun setPasswordError() {
        password.error = getString(R.string.password_error)
    }

    override fun navigateToHome() {
//        val intent = Intent(context, MainActivity::class.java)
//        startActivity(intent)
//        finish()
    }

    override fun onClick(v: View) {
        presenter!!.validateCredentials(username.text.toString(), password.text.toString())
    }
}