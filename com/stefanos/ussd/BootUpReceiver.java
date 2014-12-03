package com.stefanos.ussd;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class BootUpReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		Intent srvIntent = new Intent(context, USSDService.class);
		context.startService(srvIntent);        
	}

}
