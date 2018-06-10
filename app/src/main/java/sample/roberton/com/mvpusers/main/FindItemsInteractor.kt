package sample.roberton.com.mvpusers.main


interface FindItemsInteractor {

    interface OnFinishedListener {
        fun onFinished(items: List<String>)
    }

    fun findItems(listener: OnFinishedListener)
}