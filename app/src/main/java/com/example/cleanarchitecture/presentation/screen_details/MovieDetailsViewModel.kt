package com.example.cleanarchitecture.presentation.screen_details

import androidx.lifecycle.ViewModel
import com.example.cleanarchitecture.core.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MovieDetailsViewModel @Inject constructor(

) : BaseViewModel() {


    fun  goBack() = navigateBack()
}