package com.example.apiintegrationex.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ApiPhotos {

    @SerializedName("albumId")
    @Expose
    Integer album_Id;

    @SerializedName("id")
    @Expose
    Integer id;

    @SerializedName("title")
    @Expose
    String title;

    @SerializedName("url")
    @Expose
    String photo_url;

    @SerializedName("thumbnailUrl")
    @Expose
    String thumbnail_url;

    public ApiPhotos(Integer album_Id, Integer id, String title, String photo_url, String thumbnail_url) {
        this.album_Id = album_Id;
        this.id = id;
        this.title = title;
        this.photo_url = photo_url;
        this.thumbnail_url = thumbnail_url;
    }

    public Integer getAlbum_Id() {
        return album_Id;
    }

    public void setAlbum_Id(Integer album_Id) {
        this.album_Id = album_Id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhoto_url() {
        return photo_url;
    }

    public void setPhoto_url(String photo_url) {
        this.photo_url = photo_url;
    }

    public String getThumbnail_url() {
        return thumbnail_url;
    }

    public void setThumbnail_url(String thumbnail_url) {
        this.thumbnail_url = thumbnail_url;
    }
}
