package com.sample.packplan.util.formatter;

import com.sample.packplan.model.Item;
import com.sample.packplan.model.Pack;
import com.sample.packplan.util.Constant;

/**
 * Pack data formatter
 */
public final class PackFormatter implements Formattable<Pack> {

    private static final Formattable ITEM_FORMATTER = new PackFormatter();
    private Formattable itemFormatter;

    /**
     * Gives the singleton instance of PackFormatter
     *
     * @return Formattable instance
     */
    public static Formattable getInstance() {
        return ITEM_FORMATTER;
    }

    private PackFormatter() {
        itemFormatter = ItemFormatter.getInstance();
    }

    /**
     * Format pack data
     *
     * @param data Pack instance
     * @return Formatted pack data string
     */
    public String format(final Pack data) {
        if (data == null) {
            return Constant.NEW_LINE;
        }
        StringBuilder result = new StringBuilder();
        result.append(Constant.PACK_NUMBER);
        result.append(data.getId());
        result.append(Constant.NEW_LINE);
        for (Item item : data.getItems()) {
            result.append(itemFormatter.format(item));
            result.append(Constant.NEW_LINE);
        }
        result.append(Constant.PACK_LENGTH);
        result.append(data.getTotalPackLength());
        result.append(Constant.UNIT_METER);
        result.append(Constant.COMMA);
        result.append(Constant.EMPTY_STRING);
        result.append(Constant.PACK_WEIGHT);
        result.append(data.getTotalPackWeight());
        result.append(Constant.UNIT_KILOGRAM);
        result.append(Constant.NEW_LINE);
        result.append(Constant.SEPARATOR);
        return result.toString();
    }

}
