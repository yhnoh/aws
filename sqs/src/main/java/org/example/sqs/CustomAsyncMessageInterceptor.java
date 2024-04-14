package org.example.sqs;

import io.awspring.cloud.sqs.listener.interceptor.AsyncMessageInterceptor;
import org.springframework.messaging.Message;

import java.util.Collection;
import java.util.concurrent.CompletableFuture;

//@Component
public class CustomAsyncMessageInterceptor<T> implements AsyncMessageInterceptor<T> {

    @Override
    public CompletableFuture<Message<T>> intercept(Message<T> message) {
        throw new IllegalArgumentException();
//        return AsyncMessageInterceptor.super.intercept(message);
    }

    @Override
    public CompletableFuture<Collection<Message<T>>> intercept(Collection<Message<T>> messages) {
        throw new IllegalArgumentException();
//        return AsyncMessageInterceptor.super.intercept(messages);
    }

    @Override
    public CompletableFuture<Void> afterProcessing(Message<T> message, Throwable t) {
        throw new IllegalArgumentException();
//        return AsyncMessageInterceptor.super.afterProcessing(message, t);
    }

    @Override
    public CompletableFuture<Void> afterProcessing(Collection<Message<T>> messages, Throwable t) {
        throw new IllegalArgumentException();
//        return AsyncMessageInterceptor.super.afterProcessing(messages, t);
    }
}
