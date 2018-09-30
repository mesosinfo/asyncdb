package com.github.mslenc.asyncdb.mysql.message.client;

import com.github.mslenc.asyncdb.mysql.state.MySQLCommand;
import com.github.mslenc.asyncdb.mysql.util.MySQLIO;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import static java.nio.charset.StandardCharsets.UTF_8;

public class PreparedStatementPrepareMessage extends ClientMessage {
    private final String statement;

    public PreparedStatementPrepareMessage(MySQLCommand command, String statement) {
        super(command);

        this.statement = statement;
    }

    @Override
    public ByteBuf getPacketContents() {
        ByteBuf contents = Unpooled.buffer(statement.length() + 25);
        contents.writeByte(MySQLIO.PACKET_HEADER_STMT_PREPARE);
        contents.writeCharSequence(statement, UTF_8);
        return contents;
    }

    @Override
    public String toString(boolean fullDetails) {
        if (fullDetails || statement.length() <= 100) {
            return "STMT_PREPARE(query=\"" + statement + "\")";
        } else {
            return "STMT_PREPARE(query=\"" + statement.substring(0, 50) + "[...]" + statement.substring(statement.length() - 50) + "\")";
        }
    }
}