package com.github.mslenc.asyncdb.mysql.binary.encoder;

import com.github.mslenc.asyncdb.common.ULong;
import com.github.mslenc.asyncdb.mysql.codec.CodecSettings;
import com.github.mslenc.asyncdb.mysql.util.MySQLIO;
import io.netty.buffer.ByteBuf;

public class ULongEncoder implements BinaryEncoder {
    private static final ULongEncoder instance = new ULongEncoder();

    public static ULongEncoder instance() {
        return instance;
    }

    @Override
    public void encode(Object value, ByteBuf buffer, CodecSettings codecSettings) {
        buffer.writeLongLE(((ULong)value).longValue());
    }

    @Override
    public int encodesTo() {
        return MySQLIO.FIELD_TYPE_LONGLONG | MySQLIO.PREP_STMT_UNSIGNED_FLAG;
    }
}