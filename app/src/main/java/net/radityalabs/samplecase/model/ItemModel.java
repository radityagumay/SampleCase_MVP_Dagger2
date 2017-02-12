package net.radityalabs.samplecase.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by radityagumay on 2/11/17.
 */

public class ItemModel implements Parcelable {
    public int id;
    public String name;
    public String imageUrl;

    public ItemModel() {

    }

    protected ItemModel(Parcel in) {
        id = in.readInt();
        name = in.readString();
        imageUrl = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(imageUrl);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ItemModel> CREATOR = new Creator<ItemModel>() {
        @Override
        public ItemModel createFromParcel(Parcel in) {
            return new ItemModel(in);
        }

        @Override
        public ItemModel[] newArray(int size) {
            return new ItemModel[size];
        }
    };
}
