package com.sample.packplan.util.formatter;

import com.sample.packplan.model.Item;
import com.sample.packplan.util.Constant;

/**
 * Item data formatter
 */
public final class ItemFormatter implements Formattable<Item> {

    private static final Formattable ITEM_FORMATTER = new ItemFormatter();

    /**
     * Gives the singleton instance of ItemFormatter
     *
     * @return Formattable object
     */
    public static Formattable getInstance() {
        return ITEM_FORMATTER;
    }

    private ItemFormatter() {
        // to restrict creating instances
    }

    /**
     * Format given item data
     *
     * @param data Item object
     * @return String value of formatted data
     */
    public String format(final Item data) {
        if (data == null) {
            return Constant.NEW_LINE;
        }
        StringBuilder result = new StringBuilder();
        result.append(data.getId());
        result.append(Constant.COMMA);
        result.append(data.getLength());
        result.append(Constant.COMMA);
        result.append(data.getQuantity());
        result.append(Constant.COMMA);
        result.append(data.getPieceWeight());
        result.append(Constant.NEW_LINE);
        return result.toString();
    }
}
