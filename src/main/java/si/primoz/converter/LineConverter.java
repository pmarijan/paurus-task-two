package si.primoz.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import si.primoz.model.FoRandom;

import java.util.regex.Pattern;

@Component
public class LineConverter implements Converter<String, FoRandom> {

    private static final Pattern SPLIT_PATTERN = Pattern.compile("\\|");

    @Override
    public FoRandom convert(String line) {
        var splitedLine = SPLIT_PATTERN.split(line, 4);
        return new FoRandom(splitedLine[0], splitedLine[1], splitedLine[2], splitedLine[3]);
    }
}
