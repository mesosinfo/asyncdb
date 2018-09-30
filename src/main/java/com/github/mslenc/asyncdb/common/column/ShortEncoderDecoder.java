package com.github.mslenc.asyncdb.common.column;

public class ShortEncoderDecoder implements ColumnDecoder {
    private static final ShortEncoderDecoder instance = new ShortEncoderDecoder();

    public static ShortEncoderDecoder instance() {
        return instance;
    }

    @Override
    public Short decode(String value) {
        return Short.valueOf(value);
    }
}