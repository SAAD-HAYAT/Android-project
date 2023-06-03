package com.saad.androidproject.ui.userlist;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.saad.androidproject.databinding.FragmentUserListBinding;
import com.saad.androidproject.retrofit.UserList;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link }.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyUsersListRecyclerViewAdapter extends RecyclerView.Adapter<MyUsersListRecyclerViewAdapter.ViewHolder> {

    private final List<UserList.Datum> mValues;

    public MyUsersListRecyclerViewAdapter(List<UserList.Datum> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentUserListBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mIdView.setText(String.valueOf(mValues.get(position).id));
        holder.firstNameView.setText(mValues.get(position).first_name);
        holder.lastNameView.setText(mValues.get(position).last_name);
//        holder.avatarView.setText(mValues.get(position).avatar);

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView mIdView;
        public final TextView firstNameView;
        public final TextView lastNameView;
//        public final TextView avatarView;

        public ViewHolder(FragmentUserListBinding binding) {
            super(binding.getRoot());
            mIdView = binding.id;
            firstNameView = binding.firstName;
            lastNameView = binding.lastName;
//            avatarView = binding.avatar;
        }


    }
}