package si.primoz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import si.primoz.service.FoService;

import java.time.Duration;

@Slf4j
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@SpringBootApplication
public class App implements CommandLineRunner {

    private final FoService foService;

    public static void main( String[] args ) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("App started");

        val numRecords = foService.saveStreamData("fo_random.txt");
        log.info("Inserted {} records", numRecords);

        var minTimestamp = foService.getMinTimestamp();
        log.info("MIN timestamp: {}", minTimestamp);

        var maxTimestamp = foService.getMaxTimestamp();
        log.info("MAX timestamp: {}", maxTimestamp);

        var duration = Duration.between(minTimestamp, maxTimestamp).toMillis();
        log.info("Duration: {} ms", duration);

        log.info("App stopped");
    }
}
