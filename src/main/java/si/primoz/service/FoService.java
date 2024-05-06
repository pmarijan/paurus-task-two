package si.primoz.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import si.primoz.converter.LineConverter;
import si.primoz.repository.FoRandomRepository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FoService {

    public static final String ASSERT_FILENAME_NOT_NULL_OR_EMPTY = "Given 'filename' should not be null or empty";

    private final FoRandomRepository foRandomRepository;
    private final LineConverter lineConverter;

    public long saveStreamData(String filename) throws URISyntaxException {
        Assert.hasLength(filename, ASSERT_FILENAME_NOT_NULL_OR_EMPTY);

        var file = Path.of(this.getClass().getClassLoader().getResource(filename).toURI());

        //we skip first line of file because it contains column names
        try (Stream<String> linesStream = Files.lines(file).skip(1)) {
            val input = linesStream.map(lineConverter::convert)
                    .collect(Collectors.toCollection(TreeSet::new));

            return foRandomRepository.saveAllAndFlush(input).size();
        } catch (IOException e) {
            log.error("Error reading data from file.", e);
        }
        return 0;
    }

    public Instant getMinTimestamp() {
        return foRandomRepository.findMinTimestamp();
    }

    public Instant getMaxTimestamp() {
        return foRandomRepository.findMaxTimestamp();
    }
}