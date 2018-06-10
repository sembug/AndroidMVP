package sample.roberton.com.mvpusers.login

import android.os.Handler
import android.text.TextUtils

class LoginInteractorImpl : LoginInteractor {

    override fun login(username: String, password: String, listener: LoginInteractor.OnLoginFinishedListener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        Handler().postDelayed(Runnable {
            if (TextUtils.isEmpty(username)) {
                listener.onUsernameError()
                return@Runnable
            }
            if (TextUtils.isEmpty(password)) {
                listener.onPasswordError()
                return@Runnable
            }
            listener.onSuccess()
        }, 2000)
    }
}