package sample.roberton.com.mvpusers.users.create.presenter

import sample.roberton.com.mvpusers.users.model.User

interface CreateUserPresenter {
    fun createUser(user: User)

    fun onDestroy()
}