package com.sample.packplan.service;

import com.sample.packplan.exception.PackPlannerValidationException;
import com.sample.packplan.model.Item;
import com.sample.packplan.model.Pack;
import com.sample.packplan.model.PackStack;
import com.sample.packplan.model.userdata.Constraint;
import com.sample.packplan.model.userdata.UserData;
import com.sample.packplan.service.io.IODeviceService;
import com.sample.packplan.service.io.StandardIODeviceImpl;
import com.sample.packplan.util.Constant;
import com.sample.packplan.util.formatter.Formattable;
import com.sample.packplan.util.formatter.PackFormatter;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Pack planner service to plan given items
 */
public final class PackPlannerServiceImpl implements PackPlannerService {
    private static final Logger logger = Logger.getLogger(PackPlannerServiceImpl.class.getPackage().getName());
    private static final PackPlannerService PACK_PLANNER_SERVICE = new PackPlannerServiceImpl();
    private Formattable<Pack> packFormatter;
    private IODeviceService<List<String>, String> standardIODevice;

    /**
     * Gives singleton instance of PackPlannerServiceImpl
     *
     * @return PackPlannerService instance
     */
    public static PackPlannerService getInstance() {
        return PACK_PLANNER_SERVICE;
    }

    private PackPlannerServiceImpl() {
        this.packFormatter = PackFormatter.getInstance();
        this.standardIODevice = StandardIODeviceImpl.getInstance();
    }

    /**
     * Plan given items into packs
     *
     * @param userData user data
     * @return Planned items as a pack stack
     * @throws PackPlannerValidationException
     */
    public PackStack plan(final UserData userData) throws PackPlannerValidationException {
        if (userData == null || userData.getItemList().isEmpty()) {
            throw new PackPlannerValidationException("Invalid user data, please provide valid data!");
        }
        sortUserData(userData);
        return generatePacks(userData);
    }

    private void sortUserData(final UserData userData) throws PackPlannerValidationException {
        if (userData.getConstraint() == null) {
            throw new PackPlannerValidationException("Invalid user data, please provide valid data!");
        }
        logger.log(Level.INFO, "Sorting data!");
        switch (userData.getConstraint().getSortOrder()) {
            case SHORT_TO_LONG:
                Collections.sort(userData.getItemList());
                break;
            case LONG_TO_SHORT:
                Collections.sort(userData.getItemList());
                Collections.reverse(userData.getItemList());
                break;
            case NATURAL:
                // Does Nothing
        }
    }

    private PackStack generatePacks(final UserData userData) {
        logger.log(Level.INFO, "Generating packs!");
        PackStack packStack = new PackStack();
        Pack topPack;
        for (Item item : userData.getItemList()) {
            topPack = getTopPack(packStack, userData.getConstraint(), false);
            int maxPiecesPerPack = userData.getConstraint().getMaxPiecesPerPack();
            float maxWeightPerPack = userData.getConstraint().getMaxWeightPerPack();
            float nextPackWeight = topPack.getTotalPackWeight() + item.getItemWeight();
            boolean addToTopPack = (maxPiecesPerPack > topPack.getPackSize() && nextPackWeight <= maxWeightPerPack);
            topPack = getTopPack(packStack, userData.getConstraint(), !addToTopPack);
            topPack.addItem(item);
            logger.log(Level.INFO, "Item " + item.getId() + " added to the pack " + topPack.getId() + "!");
        }
        return packStack;
    }

    private Pack getTopPack(final PackStack packStack, final Constraint constraint, final boolean isNewPack) {
        if (packStack.isEmpty() || isNewPack) {
            Pack pack = new Pack();
            pack.setMaxItems(constraint.getMaxPiecesPerPack());
            pack.setAllowedMaxWeight(constraint.getMaxWeightPerPack());
            pack.setId(packStack.getTopPackId() + Constant.ID_INCREMENT);
            packStack.addPack(pack);
            logger.log(Level.INFO, "Pack " + pack.getId() + " created!");
        }
        return packStack.getTopPack();
    }

    /**
     * Disply the planned packs
     *
     * @param packStack Pack stack
     * @throws PackPlannerValidationException
     */
    public void display(PackStack packStack) throws PackPlannerValidationException {
        if (packStack != null) {
            logger.log(Level.INFO, "Displaying pack information!!");
            StringBuilder message = new StringBuilder();
            message.append(Constant.DIVIDER);
            message.append(Constant.OUTPUT_MESSAGE);
            message.append(Constant.DIVIDER);
            for (Pack pack : packStack.getPacksList()) {
                if (pack != null) {
                    message.append(packFormatter.format(pack));
                }
            }
            standardIODevice.writeData(message.toString());
        }
    }

}
