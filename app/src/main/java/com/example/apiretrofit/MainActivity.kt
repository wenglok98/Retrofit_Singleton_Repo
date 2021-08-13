package com.example.apiretrofit

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.bumptech.glide.Glide
import com.example.apiretrofit.api.MyRetrofitBuilder
import com.example.apiretrofit.databinding.ActivityMainBinding
import com.example.apiretrofit.models.UserCredential
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding
    private lateinit var token: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        var obj1 = UserCredential()
        obj1.username = "00001"
        obj1.password = "Password123!@#"
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

        /**
        Start of Using Call
         */
//        MyRetrofitBuilder.apiService.getLogin(obj1).enqueue(object : Callback<DataWrapper> {
//            override fun onResponse(call: Call<DataWrapper>, response: Response<DataWrapper>) {
//            token = responseBuild?.session?.access_token.toString()
//                Log.e("Test", "This is returned ${response.body()?.user?.credit?.currency}")
//            }
//
//            override fun onFailure(call: Call<DataWrapper>, t: Throwable) {
//                Log.e(
//                    "Test",
//                    "this is localized message error ${t.localizedMessage} and this is message ${t.message}"
//                )
//
//            }
//
//        })
        /**
        End of using call
         */
//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------


        /**
        Start of using Response
         */
        CoroutineScope(IO).launch {
//            val responseBuild = MyRetrofitBuilder.apiService.getLogin(obj1).body()
//            val token2 = responseBuild?.session?.access_token.toString()
//            if (responseBuild != null) {
//                Log.e("Test", "This is using response ${responseBuild.user?.email}")
//            }

            //Or add checking

//            val responseBuild2 = MyRetrofitBuilder.apiService.getLogin(obj1)
//            if (responseBuild2.isSuccessful) {
//                Log.e("Test", "This is using response2 ${responseBuild2.body()?.user?.email}")
//
//            }

//            Avatar
//            if (responseBuild != null) {

                /**
                First Method - Set and Get (Use setAvatar first then use getAvatar)
                 */
//
//                val task1 = async {
//                    token2?.let { responseBuild.user?.setAvatar(it) } // Get avatar from API and set into the model class
//                }.await()
                //Get image need to wait for task1(Set image to complete)
                //Can use other logic other then await

//                val task2 = async {
//                    withContext(Main) {
//
//                        //Use responseBuild.user?.get_Avatar to retrieve the bitmap
//
//                        Glide.with(applicationContext).load(responseBuild.user?.get_Avatar)
//                            .into(binding.imv)
//                    }
//                }.await()


                /**
                Second Method - Return Avatar On the Spot
                 */
//                withContext(Main)
//                {
//                    Glide.with(applicationContext).load(token2?.let {
//                        responseBuild.user?.returnAvatar(
//                            it
//                        )
//                    })
//                        .into(binding.imv)
//                }

                /**
                End of Avatar Method
                 */
//            }
        }
        /**
        End of using Response
         */

//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        /**
        Start of using Data Model
         */

//        CoroutineScope(IO).launch {
//            val datamodel = MyRetrofitBuilder.apiService.getLogin(obj1)
//
//            Log.e("test", "This is using datamodel ${datamodel.user?.email}")
//
//        }

        /**
        End of using Data Model
         */

//-------------------------------------------------------------------------------------------------------------------------------------------------------------
        /**
        Start of Meal Menu
         */
        val start_date = "2021-08-01"
        val end_date = "2021-08-08"
//        CoroutineScope(IO).launch {
//
//        MyRetrofitBuilder.apiService.getLogin(obj1).body().also {
//                token = it!!.session?.access_token.toString()
//                val listofMeal =
//                    MyRetrofitBuilder.apiService.getMealMenu(start_date, end_date, "Bearer $token")
//
//
//
//                Log.e("test", "this is multi list retrieve normal attribute ${listofMeal.body()?.get(5)?.meal_name}")
//                Log.e("test", "this is multi list retrieve allergens ${listofMeal.body()?.get(5)?.allergens?.get(1)}")
//            }
//        }

        /**
         End of Meal Menu
         */
//-------------------------------------------------------------------------------------------------------------------------------------------------------------

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}