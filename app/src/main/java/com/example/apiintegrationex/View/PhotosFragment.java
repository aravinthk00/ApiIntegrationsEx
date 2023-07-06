package com.example.apiintegrationex.View;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.apiintegrationex.Model.ApiPhotos;
import com.example.apiintegrationex.Presenter.PhotosPresenter;
import com.example.apiintegrationex.View.Adapter.PhotosAdapter;
import com.example.apiintegrationex.databinding.FragmentPhotosBinding;

import java.util.List;

public class PhotosFragment extends Fragment implements PhotosPresenter.View {

    public static final String TAG = "PhotosFragment";

    FragmentPhotosBinding binding;
    PhotosPresenter presenter;
    Context context;
    PhotosAdapter photosAdapter;

    public static PhotosFragment newInstance() {
        return new PhotosFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPhotosBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated: ");
        try {
            context = requireContext();
            //presenter.setView(context, this);
            presenter = new PhotosPresenter(this);
            //binding.photosDataButton.setOnClickListener(view1 -> {
            presenter.getPhotosFromApi();
            //Log.d(TAG, "photosDataButton: clicked ");
            // });
        } catch (NullPointerException e) {
            Log.d(TAG, "onViewCreated: null ");
        }

    }

    @Override
    public void getPhotosData(List<ApiPhotos> dataList) {
        Log.d(TAG, "getPhotosData: " + dataList.size());
        Log.d(TAG, dataList.get(0).getTitle() +"getPhotosData: image : " + dataList.get(0).getThumbnail_url());
        if (!dataList.isEmpty()) {
            binding.dataProgressBar.setVisibility(View.GONE);
            binding.photosRecyclerView.setLayoutManager(new GridLayoutManager(context, 2));
            photosAdapter = new PhotosAdapter(context, dataList);
            binding.photosRecyclerView.setAdapter(photosAdapter);
        } else {
            binding.dataProgressBar.setVisibility(View.VISIBLE);
            binding.photosRecyclerView.setVisibility(View.GONE);
        }
    }
}