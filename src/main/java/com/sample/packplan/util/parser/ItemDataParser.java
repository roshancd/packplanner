package com.sample.packplan.util.parser;

import com.sample.packplan.exception.PackPlannerParseException;
import com.sample.packplan.model.Item;
import com.sample.packplan.util.Constant;
import com.sample.packplan.util.DataUtil;

/**
 * Parser for item data
 */
public final class ItemDataParser implements Parsable<Item> {

    /**
     * Parse item data string to relevant model
     *
     * @param data item data as string
     * @return Item object
     * @throws PackPlannerParseException
     */
    public Item parse(final String data) throws PackPlannerParseException {
        Item result = new Item();
        if (data != null) {
            if (data.matches(Constant.ITEM_DATA_PATTERN)) {
                String[] itemValues = data.split(Constant.COMMA);
                if (itemValues != null && itemValues.length == 4) {
                    result.setId(DataUtil.parseInt(itemValues[0], "Invalid item id!"));
                    result.setLength(DataUtil.parseInt(itemValues[1], "Invalid item length value for item id :" +
                            result.getId() + "!"));
                    result.setQuantity(DataUtil.parseInt(itemValues[2], "Invalid item quantity value for item id :" +
                            result.getId() + "!"));
                    result.setPieceWeight(DataUtil.parseFloat(itemValues[3], "Invalid item weight value for item id: " +
                            result.getId() + " !"));
                }
            } else {
                throw new PackPlannerParseException("Invalid item format," +
                        " correct format is '[item id],[item length],[item quantity],[piece weight]'");
            }
        }
        return result;
    }

}
