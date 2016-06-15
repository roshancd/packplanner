package com.sample.packplan.service;

import com.sample.packplan.exception.PackPlannerValidationException;
import com.sample.packplan.model.PackStack;
import com.sample.packplan.model.userdata.UserData;

/**
 * Service to plan packs
 */
public interface PackPlannerService {
    PackStack plan(final UserData userData) throws PackPlannerValidationException;

    void display(PackStack packStack) throws PackPlannerValidationException;
}
