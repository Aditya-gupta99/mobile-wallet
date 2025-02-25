package org.mifospay.feature.upiSetup.viewmodel

import androidx.lifecycle.ViewModel
import com.mifospay.core.model.domain.BankAccountDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
@Suppress("UnusedParameter")
class SetUpUpiViewModal @Inject constructor() : ViewModel() {
    fun requestOtp(bankAccountDetails: BankAccountDetails?): String {
        val otp = "0000"
        return otp;
    }

    fun setupUpiPin(bankAccountDetails: BankAccountDetails?, mSetupUpiPin: String?) {
        // to do setup upi pin api
    }
}