package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {

    private final Lotto lotto;
    public static final String IS_LOTTO_NUMBER_REGEX = "[0-9]+";
    private static final String SEPARATOR = ",";
    public static final String IS_NOT_NUMBER_ERROR_MESSAGE = "1부터 45의 숫자가 아닌 문자가 포함되어 있습니다.";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    public WinningNumbers(String input) {
        String[] numbers = input.trim().split(SEPARATOR);

        validateInput(numbers);
        lotto = new Lotto(addLottoNumber(numbers));
    }

    private void validateInput(String[] numbers) {
        for(String number : numbers) {
            isLottoNumber(number);
        }
    }

    private void isLottoNumber(String number) {
        if(!number.matches(IS_LOTTO_NUMBER_REGEX)) {
            throw new IllegalArgumentException(IS_NOT_NUMBER_ERROR_MESSAGE);
        }
        if(Integer.parseInt(number) < MIN_NUMBER || Integer.parseInt(number) > MAX_NUMBER) {
            throw new IllegalArgumentException(IS_NOT_NUMBER_ERROR_MESSAGE);
        }
    }

    private List<Integer> addLottoNumber(String[] numbers) {
        List<Integer> lottoNumbers = new ArrayList<>();
        for(String number : numbers) {
            lottoNumbers.add(Integer.parseInt(number));
        }
        return lottoNumbers;
    }
}
