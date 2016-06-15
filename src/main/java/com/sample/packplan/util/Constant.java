package com.sample.packplan.util;

/**
 * Constant values for pack planner application
 */
public final class Constant {

    private Constant() {
        // To restrict creating instances of the class
    }

    public static final String EMPTY_STRING = "";
    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";
    public static final String INPUT_FORMAT = "#Please enter your data in following format:\n" +
            "[Sort order] [max pieces per pack] [max weight per pack]\n" +
            "[item id],[item length],[item quantity],[piece weight]\n" +
            "[item id],[item length],[item quantity],[piece weight]\n" +
            "[item id],[item length],[item quantity],[piece weight]\n";

    public static final String CONSTRAINT_PATTERN = "^([A-Z]*_?[A-Z]*_?[A-Z]*),([0-9]*),([0-9]*.?[0-9]+)$";
    public static final String ITEM_DATA_PATTERN = "^([0-9]*),([0-9]*),([0-9]*),([0-9]*.?[0-9]+)$";

    public static final String OUTPUT_MESSAGE = "================== Pack Planner ================== \n";
    public static final String DIVIDER = "================================================== \n";
    public static final String SEPARATOR = "-------------------------------------------------- \n";
    public static final String PACK_NUMBER = "Pack Number: ";
    public static final String PACK_LENGTH = "Pack Length: ";
    public static final String PACK_WEIGHT = "Pack Weight: ";
    public static final float LENGTH_CONVERTING_FACTOR = 1000.0f;
    public static final String UNIT_METER = "m";
    public static final String UNIT_KILOGRAM = "kg";
    public static final int ID_INCREMENT = 1;

}
