package com.sample.packplan.util;

import com.sample.packplan.exception.PackPlannerParseException;

/**
 * Enumeration to represent possible soaring orders
 */
public enum SortOrder {
    NATURAL("NATURAL"),
    SHORT_TO_LONG("SHORT_TO_LONG"),
    LONG_TO_SHORT("LONG_TO_SHORT");

    SortOrder(String value) {
        this.value = value;
    }

    private String value;

    /**
     * Gives the sort order enum of give string
     *
     * @param value sort order as a string value
     * @return SortOrder enum value
     * @throws PackPlannerParseException
     */
    public static SortOrder getByValue(String value) throws PackPlannerParseException {
        for (SortOrder sortOrder : values()) {
            if (sortOrder.getValue().equalsIgnoreCase(value)) {
                return sortOrder;
            }
        }
        throw new PackPlannerParseException("Invalid sort order!, accepted values are 'NATURAL'," +
                " 'SHORT_TO_LONG' and 'LONG_TO_SHORT' ");
    }

    private String getValue() {
        return this.value;
    }

}
