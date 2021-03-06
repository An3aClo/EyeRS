package com.github.eyers;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;

import com.github.eyers.wrapper.ItemWrapper;

/**
 * ItemLabel. Created by Matthew Van der Bijl on 2017/08/17.
 *
 * @author Matthew Van der Bijl
 */
public class ItemLabel implements Comparable<ItemLabel> {

    private final String name;
    private final Bitmap image;
    private final String description;

    public ItemLabel(String name, Bitmap image, String description) {
        this.name = name;
        this.image = image;
        this.description = description;
    }

    public ItemLabel(ItemWrapper item) {
        this.name = item.getName();
        this.image = item.getImage();
        this.description = item.getDescription();
    }

    public String getName() {
        return this.name;
    }

    public Bitmap getImage() {
        return this.image;
    }

    /**
     * @return the name of the item
     */
    public String toString() {
        return getName();
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemLabel itemLabel = (ItemLabel) o;

        if (getName() != null ? !getName().equals(itemLabel.getName()) : itemLabel.getName() != null)
            return false;
        if (getImage() != null ? !getImage().equals(itemLabel.getImage()) : itemLabel.getImage() != null)
            return false;
        return getDescription() != null ? getDescription().equals(itemLabel.getDescription()) : itemLabel.getDescription() == null;

    }

    @Override
    public int hashCode() {
        int result = getName() != null ? getName().hashCode() : 0;
        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
        result = 31 * result + (getDescription() != null ? getDescription().hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(@NonNull ItemLabel o) {
        return this.getName().compareTo(o.getName());
    }
}


