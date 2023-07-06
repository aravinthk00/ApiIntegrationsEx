package com.example.apiintegrationex.View.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.apiintegrationex.Model.ApiPhotos;
import com.example.apiintegrationex.R;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.UrlConnectionDownloader;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.ViewHolder> {

    private Context context;
    private List<ApiPhotos> photosList;

    public PhotosAdapter(Context context, List<ApiPhotos> dataList) {
        this.photosList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public PhotosAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.photos_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotosAdapter.ViewHolder holder, int position) {
        holder.photoTitleText.setText(photosList.get(position).getTitle());
        loadImage(holder.photoShapeableImage, photosList.get(position).getPhoto_url(),photosList.get(position).getThumbnail_url(), holder.imageLoadingProgress);
        holder.photoShapeableImage.setShapeAppearanceModel(new ShapeAppearanceModel().withCornerSize(10));
    }

    private void loadImage(ShapeableImageView image, String imageUrl, String thumbnailUrl, ProgressBar progressBar) {

        Log.d("TAG", "loadImage: " + imageUrl);
        progressBar.setVisibility(View.VISIBLE);
        Glide.with(context)
                .load(imageUrl)
                .centerCrop()
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                       progressBar.setVisibility(View.VISIBLE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .into(image);

//        Picasso.Builder picassoBuilder = new Picasso.Builder(context);
//        picassoBuilder.downloader(new UrlConnectionDownloader(context));
//        picassoBuilder.build().load(thumbnailUrl)
//                .placeholder((R.drawable.ic_launcher_background))
//                .error(R.drawable.ic_launcher_background)
//                .into(image);
    }

    @Override
    public int getItemCount() {
        return photosList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView photoTitleText;
        public ShapeableImageView photoShapeableImage;
        public ProgressBar imageLoadingProgress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            photoShapeableImage = itemView.findViewById(R.id.photosImageView);
            photoTitleText = itemView.findViewById(R.id.photoTitleText);
            imageLoadingProgress = itemView.findViewById(R.id.imageLoadProgressBar);
        }
    }
}
