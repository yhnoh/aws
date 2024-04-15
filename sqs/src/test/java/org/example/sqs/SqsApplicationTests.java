package org.example.sqs;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import software.amazon.awssdk.services.sqs.SqsAsyncClient;
import software.amazon.awssdk.services.sqs.model.ReceiveMessageResponse;
import software.amazon.awssdk.services.sqs.model.SendMessageResponse;

import java.util.concurrent.ExecutionException;

@SpringBootTest
class SqsApplicationTests {

    @Autowired
    private SqsAsyncClient sqsAsyncClient;

    @Test
    void listDeadLetterSourceQueuesTest() throws ExecutionException, InterruptedException {


        SendMessageResponse sendMessageResponse = sqsAsyncClient.sendMessage(builder -> {
            builder.queueUrl("HELLO").messageBody("hello world!!");
        }).get();


        while (true) {

            ReceiveMessageResponse receiveMessageResponse = sqsAsyncClient.receiveMessage(builder -> {
                builder.queueUrl("HELLO").visibilityTimeout(5);
            }).get();

            Thread.sleep(1000);
            if (receiveMessageResponse.hasMessages()) {
                System.out.println(receiveMessageResponse.messages().get(0).body());
                break;
            }
        }


//        CompletableFuture<ReceiveMessageResponse> receiveMessageResponseCompletableFuture = sqsAsyncClient.receiveMessage();
//        ReceiveMessageResponse receiveMessageResponse = receiveMessageResponseCompletableFuture.get();
//        receiveMessageResponse.messages().stream().forEach(new Consumer<Message>() {
//            @Override
//            public void accept(Message message) {
//                message.
//            }
//        });
//        sqsAsyncClient.changeMessageVisibility()
//        sqsAsyncClient.receiveMessage();
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

//        StartMessageMoveTaskResponse startMessageMoveTaskResponse = sqsAsyncClient.startMessageMoveTask(builder -> {
//            builder.sourceArn("arn:aws:sqs:ap-northeast-2:732290181542:HELLO_DLQ").build();
//        }).get();
    }

}
