package org.example.sqs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.StartMessageMoveTaskResponse;

import java.util.concurrent.ExecutionException;

@SpringBootTest
class SqsApplicationTests {

    @Autowired
    private SqsAsyncClient sqsAsyncClient;

    @Test
    void listDeadLetterSourceQueuesTest() throws ExecutionException, InterruptedException {

//        ListDeadLetterSourceQueuesResponse response = sqsAsyncClient.listDeadLetterSourceQueues(builder -> {
//            builder.queueUrl("HELLO_DLQ").build();
//        }).get();

//        ReceiveMessageResponse receiveMessageResponse = sqsAsyncClient.receiveMessage(builder -> {
//            builder.queueUrl("HELLO_DLQ").build();
//        }).get();
//        GetQueueUrlResponse getQueueUrlResponse = sqsAsyncClient.getQueueUrl(builder -> {
//            builder.queueName("HELLO_DLQ");
//        }).get();
//
//        GetQueueAttributesResponse getQueueAttributesResponse = sqsAsyncClient.getQueueAttributes(builder -> {
//            builder.queueUrl("HELLO_DLQ");
//        }).get();

        StartMessageMoveTaskResponse startMessageMoveTaskResponse = sqsAsyncClient.startMessageMoveTask(builder -> {
            builder.sourceArn("arn:aws:sqs:ap-northeast-2:732290181542:HELLO_DLQ").build();
        }).get();
    }

}
