package ma.amarghad.kafka_streams.service;

import ma.amarghad.kafka_streams.entities.PageEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Service
public class PageEventService {
    @Bean
    public Consumer<PageEvent> pageEventConsumer(){
        return (pageEvent -> {
            System.out.println(pageEvent.toString());
        });
    }

    @Bean
    public Supplier<PageEvent> pageEventSupplier(){
        return ()->{
            return PageEvent.builder()
                    .name((Math.random()>0.5)?"P1":"P2")
                    .user((Math.random()>0.5)?"U1":"U2")
                    .date(new Date())
                    .duration(new Random().nextInt(1000))
                    .build();
        };
    }

    @Bean
    public Function<PageEvent,PageEvent> pageEventFunction() {
        return (input)->{
            input.setName("Page Event ");
            input.setUser("user from stream kafka");
            return input;
        };
    }
}
