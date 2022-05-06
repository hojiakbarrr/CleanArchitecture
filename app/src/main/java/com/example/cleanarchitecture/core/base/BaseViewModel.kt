package com.example.cleanarchitecture.core.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.example.cleanarchitecture.utils.*
import com.example.cleanarchitecture.utils.navigation.Event
import androidx.lifecycle.ViewModel

import androidx.navigation.NavDirections
import com.example.cleanarchitecture.utils.navigation.NavigationCommand

abstract class BaseViewModel : ViewModel() {

    private var _navigation: MutableLiveData<Event<NavigationCommand>> = MutableLiveData()
     val navigation: LiveData<Event<NavigationCommand>> = _navigation


    fun navigate(navDirections: NavDirections) =
        _navigation.postValue(Event(NavigationCommand.ToDirection(navDirections)))

    fun navigateBack() = _navigation.postValue(Event(value = NavigationCommand.Back))


}