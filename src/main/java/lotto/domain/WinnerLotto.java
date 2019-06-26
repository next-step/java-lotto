package lotto.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class WinnerLotto extends Lotto {
    private static final String WIN_NUMBER_DELIMITER = ",";
    private static final String NUMBER_REGEX = "^[0-9]+$";

    public WinnerLotto(String inputNumbers) {
        validateInputStringNumbers(inputNumbers);
        super.lottoNumber = winLottoNumber(inputNumbers);
    }

    private LottoNumber winLottoNumber(String inputNumbers) {
        String[] stringNumbers = inputNumbers.split(WIN_NUMBER_DELIMITER);
        List<Integer> numbers = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            numbers.add(Integer.parseInt(stringNumber));
        }
        LottoNumber winLottoNumber = new LottoNumber(numbers);
        return winLottoNumber;
    }

    private void validateInputStringNumbers(String input) throws IllegalArgumentException {
        checkInputNullOrEmpty(input);
        String[] stringNumbers = getStrNumbers(input);
        checkNumbersLength(stringNumbers);
        List<Integer> numbers = new ArrayList<>();
        for (String stringNumber : stringNumbers) {
            checkNumberValue(stringNumber);
            numbers.add(Integer.parseInt(stringNumber));
        }
        checkAnotherNumberLength(numbers);
    }

    String[] getStrNumbers(String strNumbers) {
        return strNumbers.split(WIN_NUMBER_DELIMITER);
    }

    void checkInputNullOrEmpty(String input) throws IllegalArgumentException {
        if (StringUtils.isBlank(input)) {
            throw new IllegalArgumentException("당첨된 숫자를 입력해주세요.");
        }
    }

    void checkNumbersLength(String[] numbers) throws IllegalArgumentException {
        if (numbers.length != LottoNumber.MAX_LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("6개의 숫자를 쉼표(,)로 구분하여 입력해주세요.");
        }
    }

    void checkNumberValue(String val) throws IllegalArgumentException {
        if (!Pattern.matches(NUMBER_REGEX, val)) {
            throw new IllegalArgumentException("숫자형태 문자열이 와야 할 자리에 다른형태 문자열이 있습니다.");
        }
    }
}
