package sample.roberton.com.mvpusers.users.create.views

import sample.roberton.com.mvpusers.users.model.User

interface CreateUserView {
    fun showProgress()

    fun hideProgress()

//    fun setCpfError()
//
//    fun setRgError()
//
//    fun setLastNameError()
//
//    fun setEmailError()

    fun navigateToHome(user: User)

    fun isFormFilled(): Boolean
}