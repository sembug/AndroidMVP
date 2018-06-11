package sample.roberton.com.mvpusers.login

class LoginPresenterImpl(private var loginView: LoginView?, private val loginInteractor: LoginInteractor) :
        LoginPresenter, LoginInteractor.OnLoginFinishedListener {

    override fun validateCredentials(username: String, password: String) {
        loginView?.let { it.showProgress() }

        loginInteractor.login(username, password, this)
    }

    override fun onDestroy() {
        loginView = null
    }

    override fun onUsernameError() {
        if (loginView != null) {
            loginView!!.setUsernameError()
            loginView!!.hideProgress()
        }
    }

    override fun onPasswordError() {
        if (loginView != null) {
            loginView!!.setPasswordError()
            loginView!!.hideProgress()
        }
    }

    override fun onSuccess() {
        if (loginView != null) {
            loginView!!.navigateToHome()
        }
    }
}