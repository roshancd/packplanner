package com.sample.packplan.model;

import com.sample.packplan.util.Constant;

/**
 * Data model which represent item data
 */
public final class Item implements Comparable {

    private int id;
    private float length;
    private int quantity;
    private float pieceWeight;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPieceWeight() {
        return pieceWeight;
    }

    public void setPieceWeight(float pieceWeight) {
        this.pieceWeight = pieceWeight;
    }

    public float getItemWeight() {
        // (item length(m) * piece weight(kg/m))
        return (getLength() / Constant.LENGTH_CONVERTING_FACTOR) * getPieceWeight();
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getLength() != +0.0f ? Float.floatToIntBits(getLength()) : 0);
        result = 31 * result + getQuantity();
        result = 31 * result + (getPieceWeight() != +0.0f ? Float.floatToIntBits(getPieceWeight()) : 0);
        return result;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Item)) {
            return false;
        }
        Item item = (Item) object;
        if (getId() != item.getId()) {
            return false;
        }
        if (getLength() != item.getLength()) {
            return false;
        }
        if (getQuantity() != item.getQuantity()) {
            return false;
        }
        return (getPieceWeight() == item.getPieceWeight());
    }

    public int compareTo(Object another) {
        // based on the total length, items are compared
        if (!(another instanceof Item)) {
            return -1;
        }
        Item anotherItem = (Item) another;
        if (this == anotherItem) {
            return 0;
        }
        if (this.getLength() < anotherItem.getLength()) {
            return -1;
        } else {
            return 1;
        }
    }

}
