package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class ManualLottoNumberGenerator implements LottoNumberGenerator {

    private static final String DELIMITER = ", ";
    private static final Pattern PATTERN = Pattern.compile("^\\d{1,2}, \\d{1,2}, \\d{1,2}, \\d{1,2}, \\d{1,2}, \\d{1,2}$");

    private final List<Integer> numbers = new ArrayList<>();

    public ManualLottoNumberGenerator(String input) {
        validateInput(input);
        for (String number : input.split(DELIMITER)) {
            numbers.add(Integer.parseInt(number));
        }
    }

    private void validateInput(String input) {
        if (isNotMatchPattern(input)) {
            throw new IllegalArgumentException("입력값이 형식에 맞지 않습니다. ex) 1, 4, 16, 23, 44, 23");
        }
    }

    private static boolean isNotMatchPattern(String input) {
        return !PATTERN.matcher(input).matches();
    }

    @Override
    public List<Integer> generate() {
        Collections.sort(numbers);
        return this.numbers;
    }
}
