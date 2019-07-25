package com.fsb.alarmmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;

public class AlarmReciver extends BroadcastReceiver {

    Location location;
    ServiceSendLocation querySSL;

    @Override
    public void onReceive(Context context, Intent intent) {

        querySSL = new ServiceSendLocation(context);
        location = querySSL.getLastKnownLocation();

        Bundle extras = intent.getExtras();
        Intent i = new Intent("broadCastName");
        i.putExtra("Latitude", ""+location.getLatitude());
        i.putExtra("LongTitude", ""+location.getLongitude());
        context.sendBroadcast(i);
    }
}
