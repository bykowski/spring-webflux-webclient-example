package pl.bykowski.springwebfluxwebclientexample;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class Client {

    Logger logger = LoggerFactory.getLogger(Client.class);

    @EventListener(ApplicationReadyEvent.class)
    public Flux<Student> getTweetsNonBlocking() {
        Flux<Student> studentFlux = WebClient.create()
                .get()
                .uri("http://localhost:8080")
                .retrieve()
                .bodyToFlux(Student.class);

        studentFlux.subscribe(student -> logger.info(student.toString()));
        return studentFlux;
    }
}
