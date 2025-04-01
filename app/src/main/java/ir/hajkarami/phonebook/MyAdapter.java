package ir.hajkarami.phonebook;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ir.hajkarami.phonebook.databinding.ItemCardBinding;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.UserViewHolder> {
    private Context mContext ;
    private ArrayList<User> mUserArrayList;

    public MyAdapter(Context context, ArrayList<User> userArrayList) {
        mContext = context;
        mUserArrayList = userArrayList;
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {

    }
    @Override
    public int getItemCount() {
        return 0;
    }


    public class UserViewHolder extends RecyclerView.ViewHolder {
        private ItemCardBinding mItemCardBinding;


        public UserViewHolder(ItemCardBinding itemCardBinding) {
            super(itemCardBinding.getRoot());
            this.mItemCardBinding = itemCardBinding;

            mItemCardBinding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                }
            });
        }
    }

}
