package com.sample.packplan.model;

import java.util.Stack;

/**
 * Data model which represent a stack of packs
 */
public final class PackStack {

    private Stack<Pack> stack = new Stack<Pack>();

    public Stack<Pack> getPacksList() {
        return stack;
    }

    public boolean isEmpty() {
        return getPacksList().isEmpty();
    }

    public int getTopPackId() {
        if (getPacksList().isEmpty()) {
            return getPacksList().size();
        }
        return getTopPack().getId();
    }

    public Pack getTopPack() {
        return getPacksList().peek();
    }

    public void addPack(Pack pack) {
        getPacksList().push(pack);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PackStack)) {
            return false;
        }
        PackStack that = (PackStack) o;
        return stack.equals(that.stack);
    }

    @Override
    public int hashCode() {
        return stack.hashCode();
    }

}