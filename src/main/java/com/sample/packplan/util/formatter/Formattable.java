package com.sample.packplan.util.formatter;

/**
 * Formatter for any data type
 *
 * @param <E> data type
 */
public interface Formattable<E> {
    String format(final E data);
}
