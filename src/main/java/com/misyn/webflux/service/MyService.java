package com.misyn.webflux.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class MyService {
    private final WebClient webClient;

    public MyService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://jsonplaceholder.typicode.com").build();
    }

    public Mono<Details> someRestCall(String name) {
        Details details1 = new Details();

        return this.webClient.get().uri("/todos/1", name)
                .retrieve().bodyToMono(Details.class).doOnSuccess(details -> System.out.println(details.toString())).onErrorResume(error -> {
                    details1.setTitle(error.getMessage());
                    return Mono.just(details1);
                });
    }

    @Scheduled(fixedRate = 1000 * 1)
    public void someRestCall() {
        Details block = someRestCall("").block();
        System.out.println("-->"+block);
       /* WebClient client = WebClient.create();
        String name = "";
        Details details1 = new Details();

        Details block = WebClient.create("https://jsonplaceholder.typicode.com/todos/1").get()
                .retrieve()
                .bodyToMono(Details.class).doOnNext(details -> );
        System.out.println(block.toString());*/
    }
}