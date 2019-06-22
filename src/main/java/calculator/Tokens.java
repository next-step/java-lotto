package calculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Tokens {

    private List<String> tokens;

    public Tokens(List<String> tokens) {

        this.tokens = tokens;
    }

    public List<Integer> convertToIntegers() {

        validate();
        return convertToIntegerStream().collect(Collectors.toList());
    }

    private void validate() {

        try {
            boolean isContainsNegative = convertToIntegerStream().anyMatch(number -> number < 0);
            if (isContainsNegative) {
                throw new RuntimeException();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Stream<Integer> convertToIntegerStream() {

        return tokens.stream().map(Integer::parseInt);
    }
}
