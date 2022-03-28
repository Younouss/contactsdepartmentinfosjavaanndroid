package edu.uco.ythiam.p5younouss_t;

import android.content.Intent;
import android.net.Uri;
import android.view.View.OnClickListener;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

public class DetailsFragment extends Fragment {

    private TextView firstNameView = null;
    private TextView lastNameView = null;
    private TextView phoneNumberView = null;
    private TextView emailView = null;
    private static final String TAG = "FirstNameFragment";


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        firstNameView = (TextView) getActivity().findViewById(R.id.firstNameView);
        lastNameView = (TextView) getActivity().findViewById(R.id.lastNameView);
        phoneNumberView = (TextView) getActivity().findViewById(R.id.phoneNumberView);
        emailView = (TextView) getActivity().findViewById(R.id.emailView);
        emailView.setOnClickListener(new myListener());


    }
    public class myListener implements OnClickListener {
        @Override
        public void onClick(View view){
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto",emailView.getText().toString(), null));
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Announcement from Mobile App class");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "aaaa\nbbbb\ncccc");
            startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.details_fragment, container, false);
    }


    public void showFirstNameAtIndex(int index, String[] array) {
        firstNameView.setText(array[index]);
    }
    public void showLastNameAtIndex(int index, String[] array ) {
        lastNameView.setText(array[index]);
    }
    public void showPhoneNumberAtIndex(int index, String[] array) {
        phoneNumberView.setText(array[index]);
    }
    public void showEmailAtIndex(int index, String[] array) {
        emailView.setText(array[index]);
    }

}