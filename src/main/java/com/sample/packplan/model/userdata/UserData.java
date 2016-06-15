package com.sample.packplan.model.userdata;

import com.sample.packplan.model.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * User data as a one module which contains constraint and item data
 */
public final class UserData {

    private Constraint constraint;
    private List<Item> itemList = new ArrayList<Item>();

    public Constraint getConstraint() {
        return constraint;
    }

    public void setConstraint(Constraint constraint) {
        this.constraint = constraint;
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void addItem(Item item) {
        getItemList().add(item);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof UserData)) {
            return false;
        }

        UserData userData = (UserData) object;
        if (!getConstraint().equals(userData.getConstraint())) {
            return false;
        }
        return getItemList().equals(userData.getItemList());
    }

    @Override
    public int hashCode() {
        int result = getConstraint().hashCode();
        result = 31 * result + getItemList().hashCode();
        return result;
    }

}