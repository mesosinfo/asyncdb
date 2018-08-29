package com.xs0.asyncdb.mysql.binary.encoder;

import com.xs0.asyncdb.mysql.column.ColumnType;
import io.netty.buffer.ByteBuf;

import java.sql.Timestamp;

public class SQLTimestampEncoder implements BinaryEncoder {
    private static final SQLTimestampEncoder instance = new SQLTimestampEncoder();

    public static SQLTimestampEncoder instance() {
        return instance;
    }

    @Override
    public void encode(Object value, ByteBuf buffer) {
        Timestamp date = (Timestamp) value;
        LocalDateTimeEncoder.instance().encode(date.toLocalDateTime(), buffer);
        // TODO: timezone handling
    }

    @Override
    public ColumnType encodesTo() {
        return ColumnType.FIELD_TYPE_TIMESTAMP;
    }
}
