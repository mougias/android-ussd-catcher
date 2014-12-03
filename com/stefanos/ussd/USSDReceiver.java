package com.stefanos.ussd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class USSDReceiver extends BroadcastReceiver {

	private final String LOG_TAG = USSDReceiver.class.getSimpleName();
	
	public USSDReceiver() {
		Log.i(LOG_TAG, "created");
	}
	
	@Override
	public void onReceive(Context context, Intent intent) {
		Bundle extras = intent.getExtras();
		if (extras != null) {
			String text = extras.getString("MESSAGE");
			if (text != null)
				Log.i(LOG_TAG, "TA DA.  USSD Response = " + text);
		}
	}

}

