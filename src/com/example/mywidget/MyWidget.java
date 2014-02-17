package com.example.mywidget;

import java.util.Arrays;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.Toast;

public class MyWidget extends AppWidgetProvider {

	final String LOG_TAG = "myLogs";
	public static String action_b1 = "b1";
	public static String action_b2 = "b2";


	@Override
	public void onEnabled(Context context) {
		super.onEnabled(context);
		Log.d(LOG_TAG, "onEnabled");
	}

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
		super.onUpdate(context, appWidgetManager, appWidgetIds);		
		Log.d(LOG_TAG, "onUpdate " + Arrays.toString(appWidgetIds));

		RemoteViews remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget);

		//кнопка 3
		Intent b3 = new Intent(context, MainActivity.class);
		PendingIntent actionPendingIntent3 = PendingIntent.getActivity(context, 0, b3, 0);
		remoteViews.setOnClickPendingIntent(R.id.button3, actionPendingIntent3);

		//обновляем виджет
		appWidgetManager.updateAppWidget(appWidgetIds, remoteViews);
	}
	
	public void UpdateGUI(Context context, RemoteViews remoteViews) {	
		AppWidgetManager manager = AppWidgetManager.getInstance(context);
		ComponentName thisWidget = new ComponentName(context, MyWidget.class);
		manager.updateAppWidget(thisWidget, remoteViews);
	}
	
	@Override
	public void onDeleted(Context context, int[] appWidgetIds) {
		super.onDeleted(context, appWidgetIds);
		Log.d(LOG_TAG, "onDeleted " + Arrays.toString(appWidgetIds));
	}

	@Override
	public void onDisabled(Context context) {
		super.onDisabled(context);
		Log.d(LOG_TAG, "onDisabled");
	}
}