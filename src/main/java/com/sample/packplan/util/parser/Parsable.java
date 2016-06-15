package com.sample.packplan.util.parser;

import com.sample.packplan.exception.PackPlannerParseException;

/**
 * Parser for any given data
 *
 * @param <E> return type of data
 */
public interface Parsable<E> {
    E parse(final String data) throws PackPlannerParseException;
}
