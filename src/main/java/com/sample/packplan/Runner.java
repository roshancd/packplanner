package com.sample.packplan;

import com.sample.packplan.exception.PackPlannerException;
import com.sample.packplan.model.PackStack;
import com.sample.packplan.model.userdata.UserData;
import com.sample.packplan.service.PackPlannerService;
import com.sample.packplan.service.PackPlannerServiceImpl;
import com.sample.packplan.service.io.IODeviceService;
import com.sample.packplan.service.io.StandardIODeviceImpl;
import com.sample.packplan.util.DataUtil;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This is the entry point of pack planner application.
 * Runner will collect user data, create packs and display the result
 */
public final class Runner {
    private static final Logger logger = Logger.getLogger(Runner.class.getPackage().getName());

    public static void main(String[] args) {
        IODeviceService<List<String>, String> standardIODevice = StandardIODeviceImpl.getInstance();
        List<String> userDataList = standardIODevice.readData();

        try {
            UserData userData = DataUtil.parseUserData(userDataList);
            DataUtil.validateUserData(userData);
            PackPlannerService packPlanner = PackPlannerServiceImpl.getInstance();
            PackStack packStack = packPlanner.plan(userData);
            packPlanner.display(packStack);
        } catch (PackPlannerException e) {
            logger.log(Level.SEVERE, e.getMessage());
            standardIODevice.writeData(e.getMessage());
        }
    }

}