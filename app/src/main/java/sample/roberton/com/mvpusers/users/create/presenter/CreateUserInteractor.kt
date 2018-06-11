package sample.roberton.com.mvpusers.users.create.presenter

import sample.roberton.com.mvpusers.users.model.User

interface CreateUserInteractor {

    interface OnCreateUserListener {
        fun onSuccess(user: User)
    }

    fun createUser(user: User, listener: OnCreateUserListener)
}