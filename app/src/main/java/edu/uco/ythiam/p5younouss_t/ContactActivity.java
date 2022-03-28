package edu.uco.ythiam.p5younouss_t;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.FragmentActivity;
import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends FragmentActivity  {
    private static final String TAG = "FRAGMENTSTATICLAYOUT";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_contact);
    }
}
