package stringcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringInputParser {


    public StringInputParser() {

    }

    public List<String> parse(String input) {
        List<String> parsed = Arrays.stream(input.split(" "))
                .collect(Collectors.toList());

        validateParsedNumber(parsed);
        validateNumbersAndOperators(parsed);

        return parsed;
    }

    private void validateParsedNumber(List<String> parsed) {
        if (parsed.size() % 2 == 0) {
            throw new IllegalArgumentException("String number is invalid");
        }
    }

    private void validateNumbersAndOperators(List<String> parsed) {
        parsed.forEach(it -> {
                    if (!StringTokenValidator.isValidToken(it)) {
                        throw new IllegalArgumentException("Number, Operator 이외의 문자 " + it + " 포함되어 있습니다.");
                    }
                }
        );
    }


}
