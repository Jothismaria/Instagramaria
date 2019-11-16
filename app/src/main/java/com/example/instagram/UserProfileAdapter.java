package com.example.instagram;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.instagram.model.Comments;
import com.example.instagram.model.Images;
import com.example.instagram.model.Likes;
import com.example.instagram.model.Location;
import com.like.LikeButton;
import com.mikhaellopez.circularimageview.CircularImageView;
import com.squareup.picasso.Picasso;

import java.util.List;

// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class UserProfileAdapter extends RecyclerView.Adapter<UserProfileAdapter.ViewHolder> {

    Context mcontext;

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    private List<Likes> mValues;
    private List<Images> image;
    private List<Comments> comment;
    private List<Location> location;

    // Pass in the InstagramRecyclerViewAdapter array into the constructor
    public UserProfileAdapter(Context context, List<Likes> items,List<Images>images,List<Comments>comments,List<Location>locations) {
        mcontext=context;
        mValues = items;
        image = images;
        comment = comments;
        location = locations;
    }


    @Override
    public UserProfileAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_userlarge_pic, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(UserProfileAdapter.ViewHolder holder, int position) {
          Likes likes = mValues.get(position);
          Images img = image.get(position);
          Comments commet = comment.get(position);
          Location locate = location.get(position);
        holder.tv_LikesCount.setText(likes.getCount()+" Likes");
        holder.tv_CommentValue.setText(commet.getCount());
        holder.tv_Name.setText(locate.getName());

        Picasso.with(mcontext).load(String.valueOf(img.getThumbnail())).into(holder.iv_dp);

        Picasso.with(mcontext).load(String.valueOf(img.getStandardResolution())).into(holder.iv_Data);

      // Log.d("Result", "ProfilePicture: "+model.getProfilePicture());




    }

    @Override
    public int getItemCount() {
        return mValues != null ? mValues.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //  holder contains  member variable
        // for any view that will be set as you render a row
        public  View mView;


        public  TextView mtxtpost;//wasfinalall
        public  TextView mtvfollower;
        public  TextView mtxtfollower;
        public  TextView mtvfollowing;
        public  TextView mtxtfollowing;
        public  TextView meditprofile;


        TextView tv_LikesCount,tv_CommentValue,tv_Name;
        CircularImageView iv_dp;
        AppCompatImageView iv_Data,iv_Comment,iv_Send;
        LikeButton likeButton;

        //  a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View view)
        // Stores the View in a public final member variable that can be used
        // to access the context from any ViewHolder instance.
        {
            super(view);
            mView = view;

            iv_dp = view.findViewById(R.id.civ_profile);
            iv_Data =  view.findViewById(R.id.iv_Content);
            iv_Comment =  view.findViewById(R.id.iv_Comment);
            iv_Send =  view.findViewById(R.id.iv_Send);

            tv_CommentValue =  view.findViewById(R.id.tv_CommentValue);
            tv_LikesCount =  view.findViewById(R.id.tv_LikesCount);
            tv_Name =  view.findViewById(R.id.tv_Name);

            likeButton =  view.findViewById(R.id.star_button);

//            mtxtpost = (TextView) view.findViewById(R.id.textPost);
//            mtvfollower = (TextView) view.findViewById(R.id.tvFollower);
//            mtxtfollower = (TextView) view.findViewById(R.id.textFollowers);
//            mtvfollowing = (TextView) view.findViewById(R.id.tvFollowing);
//            mtxtfollowing = (TextView) view.findViewById(R.id.textFollowing);
//            meditprofile = (TextView) view.findViewById(R.id.textEditProfile);

        }

    }
}
