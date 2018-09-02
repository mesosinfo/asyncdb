package com.xs0.asyncdb.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

public class FutureUtils {
    private static final Logger log = LoggerFactory.getLogger(FutureUtils.class);

    public static <T> CompletableFuture<T> failedFuture(Throwable throwable) {
        CompletableFuture<T> result = new CompletableFuture<>();
        result.completeExceptionally(throwable);
        return result;
    }

    public static <T> CompletableFuture<T> safelyFail(CompletableFuture<T> future, Throwable cause) {
        if (future != null) {
            try {
                future.completeExceptionally(cause);
            } catch (Throwable t) {
                log.error("Future.completeExceptionally failed", t);
            }
        }

        return null;
    }

    public static <T> CompletableFuture<T> safelyComplete(CompletableFuture<T> future, T result) {
        if (future != null) {
            try {
                future.complete(result);
            } catch (Throwable t) {
                log.error("Future.complete failed", t);
            }
        }

        return null;
    }
}
