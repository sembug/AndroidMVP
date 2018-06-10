package sample.roberton.com.mvpusers.main


class MainPresenterImpl(mainView: MainView, private val findItemsInteractor: FindItemsInteractor) :
        MainPresenter, FindItemsInteractor.OnFinishedListener {

    var mainView: MainView? = null
        private set

    init {
        this.mainView = mainView
    }

    override fun onResume() {
        if (mainView != null) {
            mainView!!.showProgress()
        }

        findItemsInteractor.findItems(this)
    }

    override fun onItemClicked(position: Int) {
        if (mainView != null) {
            mainView!!.showMessage(String.format("Position %d clicked", position + 1))
        }
    }

    override fun onDestroy() {
        mainView = null
    }

    override fun onFinished(items: List<String>) {
        if (mainView != null) {
            mainView!!.setItems(items)
            mainView!!.hideProgress()
        }
    }
}