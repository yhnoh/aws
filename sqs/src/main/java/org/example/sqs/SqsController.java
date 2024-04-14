package org.example.sqs;

import io.awspring.cloud.sqs.annotation.SqsListener;
import io.awspring.cloud.sqs.operations.SqsTemplate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@Slf4j
public class SqsController {

    private final SqsTemplate sqsTemplate;


    @GetMapping("/hello")
    public void helloWorld() {
        sqsTemplate.send(to -> to.queue("HELLO")
                .payload("hello world"));
    }


    @SqsListener(queueNames = "HELLO")
    public void helloListener(String message) {
        System.out.println(message);
//        throw new IllegalArgumentException("에러 발생");
    }
}
