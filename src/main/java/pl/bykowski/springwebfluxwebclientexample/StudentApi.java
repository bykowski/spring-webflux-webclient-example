package pl.bykowski.springwebfluxwebclientexample;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class StudentApi {

    @GetMapping(produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<Student> get() {
        return Flux.just(
                new Student("Janek", "Dzbanek"),
                new Student("Ania", "Łania"),
                new Student("Łukasz", "Kuchasz"),
                new Student("Justyna", "Chityna"));
    }
}
