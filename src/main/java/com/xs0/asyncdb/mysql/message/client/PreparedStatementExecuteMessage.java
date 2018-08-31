package com.xs0.asyncdb.mysql.message.client;

import com.xs0.asyncdb.mysql.message.server.ColumnDefinitionMessage;
import io.netty.buffer.ByteBuf;

import java.util.List;
import java.util.Set;

public class PreparedStatementExecuteMessage implements ClientMessage {
    public final byte[] statementId;
    public final List<Object> values;
    public final Set<Integer> valuesToInclude;
    public final List<ColumnDefinitionMessage> parameters;

    public PreparedStatementExecuteMessage(byte[] statementId, List<Object> values, Set<Integer> valuesToInclude, List<ColumnDefinitionMessage> parameters) {
        this.statementId = statementId;
        this.values = values;
        this.valuesToInclude = valuesToInclude;
        this.parameters = parameters;
    }

    @Override
    public void encodeInto(ByteBuf packet) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int packetSequenceNumber() {
        return 0;
    }

    public int kind() {
        return PREPARED_STATEMENT_EXECUTE;
    }
}
