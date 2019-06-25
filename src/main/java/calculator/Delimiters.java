package calculator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Delimiters {
    private List<Delimiter> delimiters;

    public Delimiters() {
        delimiters = new ArrayList<>();
        delimiters.add(new Delimiter(","));
        delimiters.add(new Delimiter(":"));
    }

    private Delimiters(List<Delimiter> delimiters, Delimiter delimiter) {
        this.delimiters = delimiters;
        this.delimiters.add(delimiter);
    }

    public Delimiters addDelimiter(String delimiterString) {
        Delimiter delimiter = new Delimiter(delimiterString);
        return new Delimiters(this.delimiters, delimiter);
    }

    public List<Delimiter> getDelimiters() {
        return Collections.unmodifiableList(delimiters);
    }

    public String getDelimitersRegexString() {
        List<String> delimiterStrings = delimiters.stream()
                .map(Delimiter::getDelimiter)
                .collect(toList());
        return String.join("|", delimiterStrings);
    }
}
