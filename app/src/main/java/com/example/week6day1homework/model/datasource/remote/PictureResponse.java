
package com.example.week6day1homework.model.datasource.remote;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PictureResponse implements Parcelable
{

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("modified")
    @Expose
    private String modified;
    @SerializedName("generator")
    @Expose
    private String generator;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;
    public final static Parcelable.Creator<PictureResponse> CREATOR = new Creator<PictureResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PictureResponse createFromParcel(Parcel in) {
            return new PictureResponse(in);
        }

        public PictureResponse[] newArray(int size) {
            return (new PictureResponse[size]);
        }

    }
    ;

    protected PictureResponse(Parcel in) {
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.link = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
        this.modified = ((String) in.readValue((String.class.getClassLoader())));
        this.generator = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.items, (com.example.week6day1homework.model.datasource.remote.Item.class.getClassLoader()));
    }

    public PictureResponse() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public String getGenerator() {
        return generator;
    }

    public void setGenerator(String generator) {
        this.generator = generator;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(title);
        dest.writeValue(link);
        dest.writeValue(description);
        dest.writeValue(modified);
        dest.writeValue(generator);
        dest.writeList(items);
    }

    public int describeContents() {
        return  0;
    }

}
