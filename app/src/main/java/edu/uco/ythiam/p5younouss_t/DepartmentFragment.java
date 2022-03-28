package edu.uco.ythiam.p5younouss_t;


import android.annotation.TargetApi;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class DepartmentFragment extends DialogFragment  {
    ListView departments;
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        PopUpActivity p = new PopUpActivity();

    }

    /*@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.department_fragment, container, false);
        getDialog().setTitle("Departments info");
        departments = (ListView) view.findViewById(R.id.departmentView);
        List<String> departmentsArray = new ArrayList<String>();
        departmentsArray.add("Biology");
        departmentsArray.add("Chemistry");
        departmentsArray.add("Computer Science");
        departmentsArray.add("Engineering");
        departmentsArray.add("Funeral Services");
        departmentsArray.add("Mathematics & Statistics");
        departmentsArray.add("Nursing");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,departmentsArray);
        departments.setAdapter(adapter);
        return view;
    }*/
    @Override
    public Dialog onCreateDialog(Bundle savedInstance){
        AlertDialog.Builder  builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Departments")
        .setItems(R.array.department_array, new DialogInterface.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String url ="";
                String text ="";
                switch (i) {
                    case 0:
                        url = "http://biology.uco.edu";
                        text = "biology";
                        dismiss();
                        break;
                    case 1:
                        url = "http://chemistry.uco.edu";
                        text = "chemistry";
                        dismiss();
                        break;
                    case 2:
                        url = "http://www.uco.edu/cms/academics/engineering-and-physics/";
                        text = "engineering";
                        dismiss();
                        break;
                    case 3:
                        url = "http://www.uco.edu/cms/academics/computer-science/";
                        text = "computer science";
                        dismiss();
                        break;
                    case 4:
                        url = "http://www.uco.edu/cms/academics/funeral-service/";
                        text = "funeral services";
                        dismiss();
                        break;
                    case 5:
                        url = "http://www.math.uco.edu/";
                        text = "mathematics and statistics";
                        dismiss();
                        break;
                    case 6:
                        url = "http://www.uco.edu/cms/academics/nursing/";
                        text = "nursing";
                        dismiss();
                        break;
                }
                        Intent mNotificationIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                        PendingIntent mContentIntent = PendingIntent.getActivity(getActivity(),0,mNotificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);
                        Notification.Builder notificationBuilder = new Notification.Builder(getContext())
                                .setSmallIcon(R.drawable.icon)
                                .setAutoCancel(true)
                                .setContentTitle("Check Website")
                                .setContentText("this is the website of the "+text+" department of UCO")
                                .setContentIntent(mContentIntent);
                        NotificationManager mNotificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                        mNotificationManager.notify(0,notificationBuilder.build());

            }
        });
        return builder.create();
    }
}
