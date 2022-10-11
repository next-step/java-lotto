package domain;

import exception.NullAndEmptyException;
import java.util.Arrays;
import java.util.regex.Pattern;


public class Lotto {

    private static final Pattern VALID_INPUT_REGEX = Pattern.compile("[\\d */+-]+");

    private Integer[] lotto;

    public Lotto(String numbers) {
        validation(numbers);
        this.lotto = convertToLotto(numbers);
    }

    public static Lotto from(String lottoNumber) {
        return new Lotto(lottoNumber);
    }

    private void validation(String input) {

        if (input == null || input.isEmpty()) {
            throw new NullAndEmptyException("빈 값이 입력되었습니다. 값을 입력하세요.");
        }

        if (!VALID_INPUT_REGEX.matcher(input).matches()) {
            throw new NullAndEmptyException("잘못된 문자열이 입력되었습니다.");
        }
    }

    private Integer[] convertToLotto(String input) {
        String[] values = input.split(" ");

        return Arrays.stream(values).map(Integer::valueOf).toArray(Integer[]::new);
    }
}
