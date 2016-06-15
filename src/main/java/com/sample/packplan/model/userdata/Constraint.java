package com.sample.packplan.model.userdata;

import com.sample.packplan.util.SortOrder;

/**
 * Pack planning constraints given by user
 */
public final class Constraint {

    private SortOrder sortOrder;
    private int maxPiecesPerPack;
    private float maxWeightPerPack;

    public SortOrder getSortOrder() {
        if (sortOrder == null) {
            return SortOrder.NATURAL;
        }
        return sortOrder;
    }

    public void setSortOrder(SortOrder sortOrder) {
        this.sortOrder = sortOrder;
    }

    public int getMaxPiecesPerPack() {
        return maxPiecesPerPack;
    }

    public void setMaxPiecesPerPack(int maxPiecesPerPack) {
        this.maxPiecesPerPack = maxPiecesPerPack;
    }

    public float getMaxWeightPerPack() {
        return maxWeightPerPack;
    }

    public void setMaxWeightPerPack(float maxWeightPerPack) {
        this.maxWeightPerPack = maxWeightPerPack;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Constraint)) {
            return false;
        }
        Constraint that = (Constraint) object;

        if (getMaxPiecesPerPack() != that.getMaxPiecesPerPack()) {
            return false;
        }
        if (Float.compare(that.getMaxWeightPerPack(), getMaxWeightPerPack()) != 0) {
            return false;
        }
        return getSortOrder() == that.getSortOrder();
    }

    @Override
    public int hashCode() {
        int result = getSortOrder().hashCode();
        result = 31 * result + getMaxPiecesPerPack();
        result = 31 * result + (getMaxWeightPerPack() != +0.0f ? Float.floatToIntBits(getMaxWeightPerPack()) : 0);
        return result;
    }

}
