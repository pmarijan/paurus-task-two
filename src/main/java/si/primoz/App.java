package si.primoz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import si.primoz.repository.FoRandomRepository;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class App implements CommandLineRunner {

    @Autowired
    private FoRandomRepository foRandomRepository;

    public static void main( String[] args ) throws URISyntaxException {
        System.out.println( "Hello World!" );

        SpringApplication.run(App.class, args);

//        App app = new App();


    }

    private StreamData convertLine(String line) {
        var splitedLine = line.split("|", 4);
        return new StreamData(splitedLine[0], splitedLine[1], splitedLine[2], splitedLine[3]);
    }

//    private InputStream getFileFromResourceAsStream(String fileName) {
//
//        // The class loader that loaded the class
//        ClassLoader classLoader = getClass().getClassLoader();
//        InputStream inputStream = classLoader.getResourceAsStream(fileName);
//
//        // the stream holding the file content
//        if (inputStream == null) {
//            throw new IllegalArgumentException("file not found! " + fileName);
//        } else {
//            return inputStream;
//        }
//
//    }

    @Override
    public void run(String... args) throws Exception {
        //https://stackoverflow.com/questions/29356716/sorting-algorithm-for-continuous-data-stream
//        Set<StreamData> input = new TreeSet<>();

        var file = Path.of(this.getClass().getClassLoader().getResource("fo_random.txt").toURI());
        try (Stream<String> linesStream = Files.lines(file)) {
            var input = linesStream.map(this::convertLine)
                    .collect(Collectors.toCollection(TreeSet::new));

            foRandomRepository.saveAllAndFlush(input.iterator());
            //try to write data into db
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
