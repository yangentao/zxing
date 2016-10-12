package net.yet.myzxing;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		IntentIntegrator it = new IntentIntegrator(this);
		it.setBarcodeImageEnabled(false);
		it.setBeepEnabled(true);
		it.setCameraId(0);
		it.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
		it.setOrientationLocked(true);
		it.setPrompt("Scan Me");
		it.initiateScan();
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		IntentResult r = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
		if(r != null) {
			Toast.makeText(this,r.getContents(), Toast.LENGTH_SHORT).show();
			Log.d("scan", r.getContents());
		}else {
			super.onActivityResult(requestCode, resultCode, data);
		}
	}


	private List<String> listOf(String... ss) {
		ArrayList<String> ls = new ArrayList<>();
		for (String s : ss) {
			ls.add(s);
		}
		return ls;
	}
}
