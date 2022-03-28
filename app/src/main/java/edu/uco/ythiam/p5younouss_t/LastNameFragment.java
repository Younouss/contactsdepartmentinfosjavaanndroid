package edu.uco.ythiam.p5younouss_t;

import android.os.Bundle;
import android.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Collections;

public class LastNameFragment extends ListFragment {


    private static final String TAG = "LastNameFragment";
    String [] lastName ;
    String [] firstName ;
    String [] phoneNumber ;
    String [] email ;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        lastName = new String[getResources().getStringArray(R.array.lastName).length];
        firstName = new String[getResources().getStringArray(R.array.firstName).length];
        phoneNumber = new String[getResources().getStringArray(R.array.phoneNumber).length];
        email = new String[getResources().getStringArray(R.array.email).length];
        for(int i = 0; i < getResources().getStringArray(R.array.lastName).length; i++){
            lastName[i] = getResources().getStringArray(R.array.lastName)[i];
        }
        for(int i = 0; i < getResources().getStringArray(R.array.firstName).length; i++){
            firstName[i] = getResources().getStringArray(R.array.firstName)[i];
        }
        for(int i = 0; i < getResources().getStringArray(R.array.phoneNumber).length; i++){
            phoneNumber[i] = getResources().getStringArray(R.array.phoneNumber)[i];
        }
        for(int i = 0; i < getResources().getStringArray(R.array.email).length; i++){
            email[i] = getResources().getStringArray(R.array.email)[i];
        }
        boolean swap = true;
        int j = 0;
        while (swap) {
            swap = false;
            j++;
            for (int i = 0; i < getResources().getStringArray(R.array.lastName).length - j; i++) {
                if (lastName[i].compareTo(lastName[i + 1]) > 0) {
                    String tmp = lastName[i];
                    lastName[i] = lastName[i + 1];
                    lastName[i + 1] = tmp;
                    tmp = firstName[i];
                    firstName[i] = firstName[i + 1];
                    firstName[i + 1] = tmp;
                    tmp = phoneNumber[i];
                    phoneNumber[i] = phoneNumber[i + 1];
                    phoneNumber[i + 1] = tmp;
                    tmp = email[i];
                    email[i] = email[i + 1];
                    email[i + 1] = tmp;
                    swap = true;
                }

            }

        }
        View view =inflater.inflate(R.layout.last_name_fragment, container, false);
        setListAdapter(new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, lastName));
        return view;
    }
    @Override
    public void onListItemClick(ListView l, View v, int pos, long id) {
        getListView().setItemChecked(pos, true);
        DetailsFragment detailsFragment = (DetailsFragment) getFragmentManager().findFragmentById(R.id.details);
        detailsFragment.showFirstNameAtIndex(pos, firstName);
        detailsFragment.showLastNameAtIndex(pos, lastName);
        detailsFragment.showPhoneNumberAtIndex(pos, phoneNumber);
        detailsFragment.showEmailAtIndex(pos, email);
    }

}