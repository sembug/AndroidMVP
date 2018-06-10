package sample.roberton.com.mvpusers.login

interface LoginPresenter {
    fun validateCredentials(username: String, password: String)

    fun onDestroy()
}