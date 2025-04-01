package ir.hajkarami.phonebook

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable


class User : BaseObservable {

    var username: String = ""
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.username)
        }

    var phoneNumber: String = ""
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.phoneNumber)
        }

    var groupUser: String = ""
        @Bindable get
        set(value) {
            field = value
            notifyPropertyChanged(BR.groupUser)
        }

    constructor()
    constructor(username: String, phoneNumber: String, groupUser: String) {
        this.username = username
        this.phoneNumber = phoneNumber
        this.groupUser = groupUser
    }
}

