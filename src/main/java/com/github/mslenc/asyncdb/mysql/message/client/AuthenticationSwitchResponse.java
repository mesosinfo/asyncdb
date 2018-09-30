package com.github.mslenc.asyncdb.mysql.message.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class AuthenticationSwitchResponse extends ClientMessage {
    private final byte[] authData;

    public AuthenticationSwitchResponse(byte[] authData) {
        this.authData = authData;
    }

    @Override
    public ByteBuf getPacketContents() {
        // https://dev.mysql.com/doc/internals/en/connection-phase-packets.html#packet-Protocol::AuthSwitchResponse

        return Unpooled.wrappedBuffer(authData);
    }

    @Override
    public String toString(boolean fullDetails) {
        return "AuthSwitchResponse";
    }
}
