package sample.roberton.com.mvpusers.login

interface LoginInteractor {

    interface OnLoginFinishedListener {
        fun onUsernameError()

        fun onPasswordError()

        fun onSuccess()
    }

    fun login(username: String, password: String, listener: OnLoginFinishedListener)
}