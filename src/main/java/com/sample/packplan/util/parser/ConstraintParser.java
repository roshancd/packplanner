package com.sample.packplan.util.parser;

import com.sample.packplan.exception.PackPlannerParseException;
import com.sample.packplan.model.userdata.Constraint;
import com.sample.packplan.util.Constant;
import com.sample.packplan.util.DataUtil;
import com.sample.packplan.util.SortOrder;

/**
 * Parser for pack planner filtering constraints
 */
public final class ConstraintParser implements Parsable<Constraint> {

    /**
     * Parse constraint data to relevant model
     *
     * @param data constraint as string
     * @return Constraint object
     * @throws PackPlannerParseException
     */
    public Constraint parse(final String data) throws PackPlannerParseException {
        Constraint result = new Constraint();
        if (data != null) {
            if (data.matches(Constant.CONSTRAINT_PATTERN)) {
                String[] values = data.split(Constant.COMMA);
                if (values != null && values.length == 3) {
                    result.setSortOrder(SortOrder.getByValue(values[0]));
                    result.setMaxPiecesPerPack(DataUtil.parseInt(values[1], "Invalid max pieces per pack value!"));
                    result.setMaxWeightPerPack(DataUtil.parseFloat(values[2], "Invalid max weight per pack value!"));
                }
            } else {
                throw new PackPlannerParseException("Invalid constraint format, " +
                        "correct format is '[Sort order] [max pieces per pack] [max weight per pack]'");
            }
        }
        return result;
    }

}
