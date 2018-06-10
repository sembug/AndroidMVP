package sample.roberton.com.mvpusers.login

interface LoginView {
    fun showProgress()

    fun hideProgress()

    fun setUsernameError()

    fun setPasswordError()

    fun navigateToHome()
}