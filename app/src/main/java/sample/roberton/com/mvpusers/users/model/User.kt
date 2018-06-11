package sample.roberton.com.mvpusers.users.model

import android.os.Parcel
import android.os.Parcelable.Creator
import android.os.Parcelable

class User() : Parcelable {

    lateinit var firstName: String
    lateinit var lastName: String
    lateinit var rg: String
    lateinit var cpf: String
    lateinit var email: String

    constructor(parcel: Parcel) : this() {
        firstName = parcel.readString()
        lastName = parcel.readString()
        rg = parcel.readString()
        cpf = parcel.readString()
        email = parcel.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(rg)
        parcel.writeString(cpf)
        parcel.writeString(email)
    }

    companion object CREATOR : Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }


}