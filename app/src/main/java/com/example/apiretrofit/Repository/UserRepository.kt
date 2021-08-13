package com.example.apiretrofit.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apiretrofit.api.MyRetrofitBuilder
import com.example.apiretrofit.models.DataWrapper
import com.example.apiretrofit.models.UserCredential
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

object UserRepository {
    private var UserLive = MutableLiveData<DataWrapper>()


    fun SetUserCredential(userCredential: UserCredential) {
        CoroutineScope(IO).launch {
            UserLive.postValue(MyRetrofitBuilder.apiService.getLogin(userCredential))
        }
    }

    fun getUserLiveData(): LiveData<DataWrapper> {
        return UserLive
    }

    fun changeData(string: String) {
        val tempObject = UserLive.value
        tempObject?.user?.gender = string
        UserLive.postValue(tempObject)
      
    }
}