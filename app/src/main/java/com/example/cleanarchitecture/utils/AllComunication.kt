package com.example.cleanarchitecture.utils

import com.example.cleanarchitecture.utils.navigation.Event
import com.example.cleanarchitecture.utils.navigation.NavigationCommand

interface NavigationCommunication : Communication<Event<NavigationCommand>> {
    class Base : Communication.Base<Event<NavigationCommand>>(), NavigationCommunication
}
interface ProgressCommunication : Communication<Event<Boolean>> {
    class Base : Communication.Base<Event<Boolean>>(), ProgressCommunication
}
interface ProgressDialogCommunication : Communication<Event<Boolean>> {
    class Base : Communication.Base<Event<Boolean>>(), ProgressDialogCommunication
}
interface ErrorCommunication : Communication<Event<String>> {
    class Base : Communication.Base<Event<String>>(), ErrorCommunication
}
interface NetworkErrorCommunication : Communication<Event<Boolean>> {
    class Base : Communication.Base<Event<Boolean>>(), NetworkErrorCommunication
}