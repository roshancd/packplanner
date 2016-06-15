package com.sample.packplan.model;

import java.util.Stack;

/**
 * Data model which represent a pack
 */
public final class Pack {
    private int id;
    private float allowedMaxWeight;
    private int maxItems;
    private Stack<Item> items = new Stack<Item>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAllowedMaxWeight() {
        return allowedMaxWeight;
    }

    public void setAllowedMaxWeight(float allowedMaxWeight) {
        this.allowedMaxWeight = allowedMaxWeight;
    }

    public int getMaxItems() {
        return maxItems;
    }

    public void setMaxItems(int maxItems) {
        this.maxItems = maxItems;
    }

    public Stack<Item> getItems() {
        return items;
    }

    public int getPackSize() {
        return getItems().size();
    }

    public double getTotalPackLength() {
        double totalLength = 0;
        for (Item item : getItems()) {
            if (item != null) {
                totalLength += item.getLength();
            }
        }
        return totalLength;
    }

    public float getTotalPackWeight() {
        float totalWeight = 0.0f;
        for (Item item : getItems()) {
            if (item != null) {
                totalWeight += item.getItemWeight();
            }
        }
        return totalWeight;
    }

    public void addItem(Item item) {
        if (item != null) {
            getItems().push(item);
        }
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getAllowedMaxWeight() != +0.0f ? Float.floatToIntBits(getAllowedMaxWeight()) : 0);
        result = 31 * result + getMaxItems();
        result = 31 * result + getItems().hashCode();
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Pack)) {
            return false;
        }
        Pack pack = (Pack) object;
        if (getId() != pack.getId()) {
            return false;
        }
        if (getAllowedMaxWeight() != pack.getAllowedMaxWeight()) {
            return false;
        }
        if (getMaxItems() != pack.getMaxItems()) {
            return false;
        }
        return (getItems().equals(pack.getItems()));
    }

}
