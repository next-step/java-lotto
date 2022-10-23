package domain;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import exception.NullAndEmptyException;

public class Lotto {

    private static final Pattern VALID_INPUT_REGEX = Pattern.compile("[\\d ,]+");

    private List<Integer> lotto;

    public Lotto(String numbers) {
        inputValidation(numbers);
        this.lotto = convertToLottoForm(numbers);
    }

    public Lotto(List<Integer> numbers) {
        this.lotto = numbers;
    }

    public static Lotto from(String lottoNumber) {
        return new Lotto(lottoNumber);
    }

    public static Lotto from(List<Integer> randomLottoNumber) {
        return new Lotto(randomLottoNumber);
    }

    private void inputValidation(String input) {

        if (input == null || input.isEmpty()) {
            throw new NullAndEmptyException("빈 값이 입력되었습니다. 값을 입력하세요.");
        }

        if (!VALID_INPUT_REGEX.matcher(input).matches()) {
            throw new NullAndEmptyException("잘못된 문자열이 입력되었습니다.");
        }
    }

    private List<Integer> convertToLottoForm(String input) {
        return Arrays.stream(input.split(","))
            .map(String::trim)
            .map(Integer::valueOf)
            .collect(Collectors.toList());
    }

    public List<Integer> getLotto() {
        return lotto;
    }
}
