package com.saar.roy.sportmeetup;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserProfileFragment extends Fragment {



    public UserProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_profile, container, false);
        initializeDisplayName(view);
        initializeFriendList(view);
        return view;
    }

    private void initializeFriendList(final View view) {
        final DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        ValueEventListener postListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<String> friends = (List<String>)dataSnapshot.child("users").child(FirebaseAuth.getInstance().getCurrentUser().getUid()).getValue();
                ArrayAdapter<String> friendListAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,friends);
                ((ListView)view.findViewById(R.id.friendListView)).setAdapter(friendListAdapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
    }

    private void initializeDisplayName(View view) {
        final EditText displayNameText = (EditText) view.findViewById(R.id.displayNameText);
        displayNameText.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
        displayNameText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                FirebaseAuth.getInstance().getCurrentUser().updateProfile(
                        new UserProfileChangeRequest.Builder()
                                .setDisplayName(s.toString())
                                .build());
            }
        });
    }

}
