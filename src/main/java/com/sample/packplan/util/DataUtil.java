package com.sample.packplan.util;

import com.sample.packplan.exception.PackPlannerParseException;
import com.sample.packplan.exception.PackPlannerValidationException;
import com.sample.packplan.model.Item;
import com.sample.packplan.model.userdata.Constraint;
import com.sample.packplan.model.userdata.UserData;
import com.sample.packplan.util.parser.ConstraintParser;
import com.sample.packplan.util.parser.ItemDataParser;
import com.sample.packplan.util.parser.Parsable;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility for pack planner application
 */
public final class DataUtil {
    private static final Logger logger = Logger.getLogger(DataUtil.class.getPackage().getName());

    /**
     * Parse user data in string format to meaningful data objects
     *
     * @param userDataList list of user data as string
     * @return UserData of given data list
     * @throws PackPlannerParseException
     */
    public static UserData parseUserData(final List<String> userDataList) throws PackPlannerParseException {
        logger.log(Level.INFO, "Parsing user data!");
        UserData userData = new UserData();
        for (int i = 0; i < userDataList.size(); i++) {
            String data = userDataList.get(i);
            if (i == 0) {
                Parsable constraintParser = new ConstraintParser();
                userData.setConstraint((Constraint) constraintParser.parse(data));
            } else {
                Parsable itemDataParser = new ItemDataParser();
                userData.addItem((Item) itemDataParser.parse(data));
            }
        }
        return userData;
    }

    /**
     * Validate UserData by matching constraints
     *
     * @param userData UserData
     * @throws PackPlannerValidationException
     */
    public static void validateUserData(final UserData userData) throws PackPlannerValidationException {
        logger.log(Level.INFO, "Validating user data!");
        if (userData == null) {
            throw new PackPlannerValidationException("Invalid user data!");
        }

        if (userData.getConstraint().getMaxPiecesPerPack() < 1) {
            throw new PackPlannerValidationException("Invalid data: max pieces per pack should be greater than 0");
        }

        if (userData.getConstraint().getMaxWeightPerPack() < 1) {
            throw new PackPlannerValidationException("Invalid data: max weight per pack should be greater than 0");
        }

        for (Item item : userData.getItemList()) {
            if (item.getItemWeight() > userData.getConstraint().getMaxWeightPerPack()) {
                throw new PackPlannerValidationException("Invalid data: max weight per pack " +
                        userData.getConstraint().getMaxWeightPerPack() + " should be greater than item weight " +
                        item.getItemWeight() + " of item " + item.getId());
            }
        }
    }

    /**
     * Parse string numeric values to int
     *
     * @param value    numeric string value
     * @param errorMsg error message to show when parsing error occurs
     * @return integer value representing the give numeric value
     * @throws PackPlannerParseException
     */
    public static int parseInt(final String value, final String errorMsg) throws PackPlannerParseException {
        int result = 0;
        try {
            result = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new PackPlannerParseException(errorMsg, e);
        }
        return result;
    }

    /**
     * Parse string numeric values to float
     *
     * @param value    numeric string value
     * @param errorMsg error message to show when parsing error occurs
     * @return float value representing the give numeric value
     * @throws PackPlannerParseException
     */
    public static float parseFloat(final String value, final String errorMsg) throws PackPlannerParseException {
        float result = 0;
        try {
            result = Float.parseFloat(value);
        } catch (NumberFormatException e) {
            throw new PackPlannerParseException(errorMsg, e);
        }
        return result;
    }

    private DataUtil() {
        // to prevent creating instances
    }

}
