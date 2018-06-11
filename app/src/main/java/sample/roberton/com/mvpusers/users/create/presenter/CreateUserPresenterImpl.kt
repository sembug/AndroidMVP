package sample.roberton.com.mvpusers.users.create.presenter

import sample.roberton.com.mvpusers.users.create.views.CreateUserView
import sample.roberton.com.mvpusers.users.model.User

class CreateUserPresenterImpl(private var createUserView: CreateUserView?, private val createUserInteractor: CreateUserInteractor):
    CreateUserPresenter, CreateUserInteractor.OnCreateUserListener {

    override fun createUser(user: User) {
        if (createUserView!!.isFormFilled()) {
            createUserInteractor.createUser(user, this)
        }
    }

    override fun onDestroy() {
        createUserView = null
    }

    override fun onSuccess(user: User) {
        if (createUserView != null) {
            createUserView!!.navigateToHome(user)
        }
    }
}