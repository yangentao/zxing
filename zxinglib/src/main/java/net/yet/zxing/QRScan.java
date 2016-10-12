package net.yet.zxing;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

/**
 * Created by entaoyang@163.com on 2016-10-12.
 */

public class QRScan {
	public static void startFromActivity(Activity activity, String title, boolean beep) {
		IntentIntegrator it = new IntentIntegrator(activity);
		it.setBarcodeImageEnabled(false);
		it.setCameraId(0);
		it.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
		it.setOrientationLocked(true);

		it.setBeepEnabled(beep);
		it.setPrompt(title);
		it.initiateScan();
	}

	public static void startFromFragment(android.app.Fragment fragment, String title, boolean beep) {
		IntentIntegrator it = IntentIntegrator.forFragment(fragment);
		it.setBarcodeImageEnabled(false);
		it.setCameraId(0);
		it.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
		it.setOrientationLocked(true);

		it.setBeepEnabled(beep);
		it.setPrompt(title);
		it.initiateScan();
	}

	public static void startFromSupportFragment(android.support.v4.app.Fragment fragment, String title, boolean beep) {
		IntentIntegrator it = IntentIntegrator.forSupportFragment(fragment);
		it.setBarcodeImageEnabled(false);
		it.setCameraId(0);
		it.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
		it.setOrientationLocked(true);

		it.setBeepEnabled(beep);
		it.setPrompt(title);
		it.initiateScan();
	}

	public static Pair<Boolean, String> parseResult(int requestCode, int resultCode, Intent data) {
		IntentResult r = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
		if (r != null) {
			return Pair.create(true, r.getContents());
		} else {
			return Pair.create(false, null);
		}
	}
}
