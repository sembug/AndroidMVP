package sample.roberton.com.mvpusers.users.create.presenter

import android.os.Handler
import sample.roberton.com.mvpusers.users.model.User

class CreateUserInteractorImpl : CreateUserInteractor {

    override fun createUser(user: User, listener: CreateUserInteractor.OnCreateUserListener) {
        Handler().postDelayed(Runnable {
//            if (TextUtils.isEmpty(user.firstName)) {
//                listener.onPasswordError()
//                return@Runnable
//            }
            listener.onSuccess(user)
        }, 2000)
    }
}