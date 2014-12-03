package com.stefanos.ussd;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.IBinder;
import android.os.PatternMatcher;
import android.os.RemoteException;
import android.util.Log;
import com.android.internal.telephony.IExtendedNetworkService;

public class USSDService extends Service {

	public static final String ACTION_MESSAGE = "com.stefanos.ussdservice.message";
	
	private final String LOG_TAG = USSDService.class.getSimpleName();

	private final IExtendedNetworkService.Stub mBinder = new IExtendedNetworkService.Stub () {
		public void clearMmiString() throws RemoteException {
		}

		public void setMmiString(String number) throws RemoteException {
		}

		public CharSequence getMmiRunningText() throws RemoteException {
			return "USSD Running";
		}

		public CharSequence getUserMessage(CharSequence text) throws RemoteException {
			Intent i = new Intent();
			i.setAction(ACTION_MESSAGE);
			i.putExtra("MESSAGE", text);
			sendBroadcast(i);
			Log.i(LOG_TAG, "got ussd response : " + text);
			return text;
		}
	};

	@Override
	public IBinder onBind(Intent intent) {
		return mBinder;
	}	
}