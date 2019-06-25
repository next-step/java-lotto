package lotto.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class WinnerLotto {
    private static final String WIN_NUMBER_DELIMITER = ",";
    private static final String NUMBER_REGEX = "^[0-9]+$";

    private String inputNumbers;
    private List<Integer> numbers;

    public WinnerLotto(String inputNumbers) {
        validateInputStringNumbers(inputNumbers);
        this.inputNumbers = inputNumbers;
        this.numbers = winNumbers();
    }

    private List<Integer> winNumbers() {
        String[] strNumbers = this.inputNumbers.split(WIN_NUMBER_DELIMITER);
        List<Integer> numbers = new ArrayList<>();
        for (int index = 0; index < strNumbers.length; index++) {
            numbers.add(Integer.parseInt(strNumbers[index]));
        }
        return numbers;
    }

    private String[] getStrNumbers(String strNumbers) {
        return strNumbers.split(WIN_NUMBER_DELIMITER);
    }

    private void validateInputStringNumbers(String input) throws IllegalArgumentException {
        checkInputNullOrEmpty(input);
        String[] numbers = getStrNumbers(input);
        checkNumbersLength(numbers);
        for (int index = 0; index < numbers.length; index++) {
            checkNumberValue(numbers[index]);
            checkLottoNumberRange(numbers[index]);
        }
        checkLottoNumberAnother(numbers);
    }

    private void checkInputNullOrEmpty(String input) throws IllegalArgumentException {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("당첨된 숫자를 입력해주세요.");
        }
    }

    private void checkNumbersLength(String[] numbers) throws IllegalArgumentException {
        if (numbers.length != Lotto.MAX_LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("6개의 숫자를 쉼표(,)로 구분하여 입력해주세요.");
        }
    }

    private void checkNumberValue(String val) throws IllegalArgumentException {
        if (!Pattern.matches(NUMBER_REGEX, val)) {
            throw new IllegalArgumentException("숫자형태 문자열이 와야 할 자리에 다른형태 문자열이 있습니다.");
        }
    }

    private void checkLottoNumberRange(String val) throws IllegalArgumentException {
        int lottoNumber = Integer.parseInt(val);
        if (Lotto.MIN_LOTTO_NUM > lottoNumber || Lotto.MAX_LOTTO_NUM < lottoNumber) {
            throw new IllegalArgumentException("1부터 45사이의 숫자만 당첨숫자로 인정이 됩니다.");
        }
    }

    private void checkLottoNumberAnother(String[] numbers) throws IllegalArgumentException {
        Set anotherNums = new HashSet();
        for (int index = 0; index < numbers.length; index++) {
            anotherNums.add(numbers[index]);
        }
        if (anotherNums.size() != Lotto.MAX_LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("1부터 45사이의 서로 다른 6개의 숫자만 당첨숫자로 인정이 됩니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
