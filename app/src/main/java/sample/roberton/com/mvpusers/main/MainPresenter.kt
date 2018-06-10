package sample.roberton.com.mvpusers.main

interface MainPresenter {

    fun onResume()

    fun onItemClicked(position: Int)

    fun onDestroy()
}