package com.sample.packplan.service.io;

/**
 * Input output service which represent any device
 *
 * @param <U> Input data type
 * @param <V> Output data type
 */
public interface IODeviceService<U, V> {
    U readData();

    void writeData(V v);
}