package step1.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public List<Integer> parse(String userInput) {
        String delimiterUnifiedInput = unifyDelimiter(userInput);
        List<String> splitUserInput = parseStrings(delimiterUnifiedInput);
        return parseListToIntegers(splitUserInput);
    }

    private List<Integer> parseListToIntegers(List<String> parsedString) {
        return parsedString.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private List<String> parseStrings(String userInput) {
        return Arrays.asList(userInput.split(","));
    }

    private String unifyDelimiter(String userInput) {
        StringBuilder parsedUserInput = new StringBuilder();
        for (int userInputIdx = 0; userInputIdx < userInput.length(); userInputIdx++) {
            parsedUserInput.append(unifyDelimeterToComma(userInput.charAt(userInputIdx)));
        }
        return parsedUserInput.toString();
    }

    private String unifyDelimeterToComma(char character) {
        if (character == ':') return ",";
        return String.valueOf(character);
    }
}
