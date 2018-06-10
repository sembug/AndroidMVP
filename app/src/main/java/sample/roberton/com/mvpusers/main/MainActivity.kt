package sample.roberton.com.mvpusers.main

import android.app.Activity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import sample.roberton.com.mvpusers.R

class MainActivity : Activity(), MainView, AdapterView.OnItemClickListener {

    private var presenter: MainPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView!!.onItemClickListener = this
        presenter = MainPresenterImpl(this, FindItemsInteractorImpl())
    }

    override fun onResume() {
        super.onResume()
        presenter!!.onResume()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroy() {
        presenter!!.onDestroy()
        super.onDestroy()
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
        listView!!.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.INVISIBLE
        listView!!.visibility = View.VISIBLE
    }

    override fun setItems(items: List<String>) {
        listView!!.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, items)
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
        presenter!!.onItemClicked(position)
    }
}
