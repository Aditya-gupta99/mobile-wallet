package org.mifospay.feature.payments

import android.net.Uri
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.mifospay.core.model.domain.Transaction

const val PAYMENTS_ROUTE = "payments_route"

fun NavController.navigateToPayments(navOptions: NavOptions) = navigate(PAYMENTS_ROUTE, navOptions)

fun NavGraphBuilder.paymentsScreen(
    showQr: (String) -> Unit,
    onNewSI: () -> Unit,
    viewReceipt: (String) -> Unit,
    onAccountClicked: (String, ArrayList<Transaction>) -> Unit,
    proceedWithMakeTransferFlow: (String, String) -> Unit,
    navigateToInvoiceDetailScreen:(Uri) -> Unit
) {
    composable(route = PAYMENTS_ROUTE) {
        PaymentsRoute(
            showQr = showQr,
            onNewSI = onNewSI,
            onAccountClicked = onAccountClicked,
            viewReceipt = viewReceipt,
            proceedWithMakeTransferFlow = proceedWithMakeTransferFlow,
            navigateToInvoiceDetailScreen = navigateToInvoiceDetailScreen
        )
    }
}

