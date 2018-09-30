package com.github.mslenc.asyncdb.mysql.column;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

public class LocalDateTimeTextDecoder implements TextValueDecoder {
    private static final LocalDateTimeTextDecoder instance = new LocalDateTimeTextDecoder();

    public static LocalDateTimeTextDecoder instance() {
        return instance;
    }

    private static final String ZeroedTimestamp = "0000-00-00 00:00:00";

    private DateTimeFormatter optional =
        new DateTimeFormatterBuilder().
            appendPattern(".SSSSSS").
            toFormatter();

    private DateTimeFormatter format =
        new DateTimeFormatterBuilder().
            appendPattern("yyyy-MM-dd HH:mm:ss").
            appendOptional(optional).
            toFormatter();

    @Override
    public LocalDateTime decode(String value) {
        if (value.startsWith(ZeroedTimestamp)) {
            return null;
        } else {
            return LocalDateTime.parse(value, format);
        }
    }
}