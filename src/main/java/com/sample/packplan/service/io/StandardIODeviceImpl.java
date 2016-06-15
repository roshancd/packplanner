package com.sample.packplan.service.io;

import com.sample.packplan.util.Constant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Service which represent the standard input/output interface
 */
public final class StandardIODeviceImpl implements IODeviceService<List<String>, String> {

    private static final IODeviceService STANDARD_IO_DEVICE = new StandardIODeviceImpl();

    /**
     * Gives the singleton instance of StandardIODeviceImpl
     *
     * @return IODeviceService instance
     */
    public static IODeviceService getInstance() {
        return STANDARD_IO_DEVICE;
    }

    private StandardIODeviceImpl() {
        // to restrict creating instances
    }

    /**
     * Read data from device interface
     *
     * @return List of string values
     */
    public List<String> readData() {
        Scanner scanner = new Scanner(System.in);

        // read from standard input
        System.out.println(Constant.INPUT_FORMAT);
        List<String> dataList = new ArrayList<String>();

        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (Constant.EMPTY_STRING.equals(nextLine)) {
                break;
            } else {
                dataList.add(nextLine);
            }
        }
        return dataList;
    }

    /**
     * Write data to device interface
     *
     * @param data String data to be written to interface
     */
    public void writeData(final String data) {
        if (data != null) {
            // write to standard output
            System.out.println(data);
        }
    }

}
