package com.example.musiconvinyl;

import android.os.Parcel;
import android.os.Parcelable;

public class Vinyl implements Parcelable {
    private String name, remarks, photo, description, price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.remarks);
        dest.writeString(this.photo);
        dest.writeString(this.description);
        dest.writeString(this.price);
    }

    public Vinyl() {
    }
    protected Vinyl(Parcel in) {
        this.name = in.readString();
        this.remarks = in.readString();
        this.photo = in.readString();
        this.description = in.readString();
        this.price = in.readString();
    }
    public static final Parcelable.Creator<Vinyl> CREATOR = new Parcelable.Creator<Vinyl>() {
        @Override
        public Vinyl createFromParcel(Parcel source) {
            return new Vinyl(source);
        }
        @Override
        public Vinyl[] newArray(int size) {
            return new Vinyl[size];
        }
    };
}
