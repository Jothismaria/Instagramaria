package com.example.instagram.net;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.R;
import com.example.instagram.model.Datum;
import com.example.instagram.model.Images;
import com.example.instagram.model.MediaRecent;
import com.like.LikeButton;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.List;
// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class InstagramRecyclerViewAdapter extends RecyclerView.Adapter<InstagramRecyclerViewAdapter.ViewHolder> {

    Context mcontext;

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    private List<Datum> mValues;
    private Images img;

    // Pass in the InstagramRecyclerViewAdapter array into the constructor
    public InstagramRecyclerViewAdapter(Context context, List<Datum> items) {
        mcontext=context;
        mValues = items;
    }


    @Override
    public InstagramRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_userlarge_pic, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("NewApi")
    @Override
    public void onBindViewHolder(InstagramRecyclerViewAdapter.ViewHolder holder, int position) {
          Datum model = mValues.get(position);

        holder.iv_profile.setImageBitmap(model.getImages());
       holder.civ_profile.setImageIcon(model.getUsersInPhoto());
       holder.ploc.setText((CharSequence) model.getLocation());
        holder.tv_LikesCount.setText((CharSequence) model.getLikes());
        holder.tv_CommentValue.setText((CharSequence)model.getComments());
       // holder.iv_Send.set((CharSequence)model.getComments());

       // Picasso.with(mcontext).load(model.getProfilePicture()).into(holder.iv_profile);

/*
        Likes likes = mValues.get(position);
*/
        /*Images img = model.get(position);
        Comments commet = comment.get(position);
        Location locate = location.get(position);*/
        holder.tv_LikesCount.setText(model.getLikes()+" Likes");
        holder.tv_CommentValue.setText((CharSequence) model.getComments());
       // holder.tv_Name.setText(model.get());

        Picasso.with(mcontext).load(String.valueOf(img.getThumbnail())).into(holder.iv_dp);

        Picasso.with(mcontext).load(String.valueOf(img.getStandardResolution())).into(holder.iv_Data);


    }

    @Override
    public int getItemCount() {
        return mValues != null ? mValues.size() : 0;
    }

    public void setData(MediaRecent body) {
        this.mValues = body.getData();
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public  View mView;
        ImageView iv_profile;
        CircularImageView civ_profile,iv_dp;
        TextView tv_Name,ploc,tv_LikesCount,tv_CommentValue;
        AppCompatImageView iv_Data,iv_Comment,iv_Send;
        LikeButton likeButton;

                                public  TextView mpost;
                                public  TextView mtxtpost;//wasfinalall
                                public  TextView mtvfollower;
                                public  TextView mtxtfollower;
                                public  TextView mtvfollowing;
                                public  TextView mtxtfollowing;
                                public  TextView meditprofile;
        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View view)
        // Stores the View in a public final member variable that can be used
        // to access the context from any ViewHolder instance.
        {
            super(view);
            mView = view;

            mpost = (TextView) view.findViewById(R.id.tvPost);
            iv_profile =  view.findViewById(R.id.pimage);
            civ_profile = view.findViewById(R.id.civ_profile);
            tv_Name = view.findViewById(R.id.tv_Name);
            ploc = view.findViewById(R.id.ploc);
            iv_dp = view.findViewById(R.id.iv_dp);
            tv_LikesCount = view.findViewById(R.id.tv_LikesCount);
            tv_CommentValue = view.findViewById(R.id.tv_CommentValue);
            iv_Data = view.findViewById(R.id.iv_Data);
            iv_Comment = view.findViewById(R.id.iv_Comment);
            iv_Send = view.findViewById(R.id.iv_Send);
            likeButton = view.findViewById(R.id.star_button);
            /*
            mtxtpost = (TextView) view.findViewById(R.id.textPost);
            mtvfollower = (TextView) view.findViewById(R.id.tvFollower);
            mtxtfollower = (TextView) view.findViewById(R.id.textFollowers);
            mtvfollowing = (TextView) view.findViewById(R.id.tvFollowing);
            mtxtfollowing = (TextView) view.findViewById(R.id.textFollowing);
            meditprofile = (TextView) view.findViewById(R.id.textEditProfile);
*/
        }

    }
}
