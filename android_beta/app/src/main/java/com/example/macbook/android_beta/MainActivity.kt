package com.example.macbook.android_beta
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.macbook.android_beta.models.RequestModel
import java.io.Serializable


class MainActivity : AppCompatActivity() {
    var model : RequestModel? = null;
    private var arrayWithAdInformation: MutableList<RequestModel> = mutableListOf()
    private  var onePersonInformation: MutableList<String> = mutableListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun initRecyclerView(array: MutableList<RequestModel>) {
        val recyclerView: RecyclerView = findViewById<RecyclerView>(R.id.rv_main_page)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = RequestAdapter(array)
    }
    fun addNewRequest(view: View){
        onePersonInformation.clear()
        setContentView(R.layout.activity_new_ad_first_page)
    }
    fun backToMainPage(view: View){
        setContentView(R.layout.activity_main)
        initRecyclerView(arrayWithAdInformation)
    }
    fun goToSecondPage(view: View){
        val name = findViewById<EditText>(R.id.tiet_ad_name).text.toString()
        val description: String?  = findViewById<EditText>(R.id.tiet_ad_description).text.toString()
        val dormName = findViewById<Spinner>(R.id.spinner).selectedItem.toString()
        onePersonInformation.add(name)
        onePersonInformation.add(description!!)
        onePersonInformation.add(dormName)
        setContentView(R.layout.activity_new_ad_second_page)
    }
    fun backToFirstNewAdPage(view: View){
        onePersonInformation.clear()
        setContentView(R.layout.activity_new_ad_first_page)
    }
    fun appendResults(view: View){
        val tags = findViewById<EditText>(R.id.tiet_ad_tags).text.toString()
        val price = findViewById<EditText>(R.id.tiet_price).text.toString()
        onePersonInformation.add(tags)
        onePersonInformation.add(price)
        setContentView(R.layout.activity_main)
        arrayWithAdInformation.add(RequestModel(
                onePersonInformation[0],
                onePersonInformation[1],
                onePersonInformation[2],
                onePersonInformation[3].split(','),
                onePersonInformation[4]))
        initRecyclerView(arrayWithAdInformation)
    }

}
