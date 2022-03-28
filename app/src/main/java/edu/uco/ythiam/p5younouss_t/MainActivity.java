package edu.uco.ythiam.p5younouss_t;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.FragmentManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {
    private Button contact, info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contact = (Button) findViewById(R.id.contact);
        info = (Button) findViewById(R.id.info);
        MyListener listen =  new MyListener();
        contact.setOnClickListener(listen);
        info.setOnClickListener(listen);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v == contact) {
                Intent intent = new Intent(MainActivity.this, ContactActivity.class);
                startActivity(intent);
            }
            if (v == info) {
                FragmentManager f = getFragmentManager();
                DepartmentFragment departmentFragment = new DepartmentFragment();
                departmentFragment.show(f, "Sample Fragment");
            }
        }
    }
}
