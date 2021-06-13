package com.aleshatech.mvvmsampleapp.login.model.datamodel

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class LoginModel {
    @SerializedName("error")
    @Expose
    private var error = 0

    @SerializedName("errorMsg")
    @Expose
    private var errorMsg: String? = null

    @SerializedName("data")
    @Expose
    private var data: Data? = null

    fun getError(): Int {
        return error
    }

    fun setError(error: Int) {
        this.error = error
    }

    fun getErrorMsg(): String? {
        return errorMsg
    }

    fun setErrorMsg(errorMsg: String?) {
        this.errorMsg = errorMsg
    }

    fun getData(): Data? {
        return data
    }

    fun setData(data: Data?) {
        this.data = data
    }

    class Data {
        @SerializedName("customers")
        @Expose
        var customers: Customers? = null

        @SerializedName("addresses")
        @Expose
        var addresses: Any? = null

        @SerializedName("members")
        @Expose
        var members: Any? = null

        @SerializedName("memberships")
        @Expose
        var memberships: Any? = null

        @SerializedName("gifts")
        @Expose
        var gifts: Any? = null

        @SerializedName("token")
        @Expose
        var token: String? = null
    }

    class Customers {
        @SerializedName("id")
        @Expose
        var id: Long = 0

        @SerializedName("name")
        @Expose
        var name: String? = null

        @SerializedName("email")
        @Expose
        var email: String? = null

        @SerializedName("phone")
        @Expose
        var phone: String? = null

        @SerializedName("photo")
        @Expose
        var photo: String? = null

        @SerializedName("dob")
        @Expose
        var dob: String? = null

        @SerializedName("gender")
        @Expose
        var gender: String? = null

        @SerializedName("status")
        @Expose
        var status: String? = null

        @SerializedName("provider")
        @Expose
        var provider: String? = null

        @SerializedName("provider_id")
        @Expose
        var providerId: String? = null

        @SerializedName("created_at")
        @Expose
        var createdAt: String? = null

        @SerializedName("updated_at")
        @Expose
        var updatedAt: String? = null

        @SerializedName("deleted_at")
        @Expose
        var deletedAt: String? = null

        @SerializedName("newsletter")
        @Expose
        var newsletter = 0

        @SerializedName("email_verify")
        @Expose
        var emailVerify: String? = null

        @SerializedName("social_email")
        @Expose
        var socialEmail: String? = null

        @SerializedName("balance")
        @Expose
        var balance = 0

        @SerializedName("photoUrl")
        @Expose
        var photoUrl: String? = null
    }
}