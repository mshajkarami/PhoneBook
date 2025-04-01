package ir.hajkarami.phonebook;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import ir.hajkarami.phonebook.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> mUsers;
    private MyAdapter mMyAdapter;
    private ActivityMainBinding mActivityMainBinding;

    // Firebase
    private DatabaseReference mDatabaseReference;
    private FirebaseDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // مقداردهی Firebase
        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseReference = mDatabase.getReference("Users");

        // مقداردهی لیست کاربران و آداپتور
        mUsers = new ArrayList<>();
        mMyAdapter = new MyAdapter(this, mUsers);

        RecyclerView mRecyclerView = mActivityMainBinding.recyclerView;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mMyAdapter);


        mDatabaseReference.addValueEventListener(new ValueEventListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                mUsers.clear();
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    User user = dataSnapshot.getValue(User.class);
                    if (user != null) {
                        mUsers.add(user);
                    }
                }
                mMyAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Database error: " + error.getMessage());
            }
        });
    }
}
