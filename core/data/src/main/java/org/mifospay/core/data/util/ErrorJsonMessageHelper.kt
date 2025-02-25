package org.mifospay.core.data.util

import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException

/**
 * Created by ankur on 26/June/2018
 */
object ErrorJsonMessageHelper {
    @JvmStatic
    @Throws(JSONException::class)
    fun getUserMessage(message: String?): String {
        val jsonObject = JSONObject(message)
        return jsonObject.getJSONArray("errors")
            .getJSONObject(0).getString("defaultUserMessage")
    }

    @JvmStatic
    fun getUserMessage(e: Throwable): String? {
        var message: String?
        try {
            message = (e as HttpException).response()?.errorBody()?.string().toString()
            message = getUserMessage(message)
        } catch (e1: Exception) {
            message = e1.message.toString()
        }
        return message
    }
}
