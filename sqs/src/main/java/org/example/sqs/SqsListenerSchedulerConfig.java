package org.example.sqs;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.DeleteMessageResponse;
import software.amazon.awssdk.services.sqs.model.Message;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
@Slf4j
public class SqsListenerSchedulerConfig {

    private final SqsAsyncClient sqsAsyncClient;

    @Scheduled(fixedRate = 3, timeUnit = TimeUnit.SECONDS)
    public void sqsListenerScheduler() throws ExecutionException, InterruptedException {
        this.deleteReceiveMessage();
    }

    public void notDeleteReceiveMessage() throws ExecutionException, InterruptedException {
        ReceiveMessageResponse receiveMessageResponse = sqsAsyncClient.receiveMessage(builder -> {
            builder.queueUrl("HELLO").visibilityTimeout(5);
        }).get();

        if (receiveMessageResponse.hasMessages()) {
            log.info("receiveMessageResponse = {}", receiveMessageResponse);
        }
    }

    public void deleteReceiveMessage() throws ExecutionException, InterruptedException {
        ReceiveMessageResponse receiveMessageResponse = sqsAsyncClient.receiveMessage(builder -> {
            builder.queueUrl("HELLO");
        }).get();

        if (receiveMessageResponse.hasMessages()) {
            //수신 받은 메시지 확인
            log.info("receive message = {}", receiveMessageResponse);

            //수신 받은 메시지 SQS 대기열에서 삭제
            List<String> receiptHandles = receiveMessageResponse.messages().stream().map(Message::receiptHandle).collect(Collectors.toList());
            for (String receiptHandle : receiptHandles) {
                DeleteMessageResponse deleteMessageResponse = sqsAsyncClient.deleteMessage(builder -> {
                    builder.queueUrl("HELLO").receiptHandle(receiptHandle);
                }).get();

                log.info("delete message = {}", deleteMessageResponse);
            }
        }


    }

}
