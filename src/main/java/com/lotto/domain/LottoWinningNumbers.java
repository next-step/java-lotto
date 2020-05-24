package com.lotto.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumbers {

    private static final String WINNING_LOTTO_NUMBER_SPLIT_SYMBOL = ",";
    private static final Integer COUNT_OF_LOTTO_WINNING_NUMBERS = 6;

    private List<Integer> numbers;

    private LottoWinningNumbers() {

    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public static LottoWinningNumbers manipulateInputWinningLottoNumbers(String input) {

        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers();

        String[] splitInput = StringUtils.split(input, WINNING_LOTTO_NUMBER_SPLIT_SYMBOL);
        validateInputWinningLottoNumbers(splitInput);

        List<Integer> converted = new ArrayList<>();
        for (String inputValue : splitInput) {
            String trimResult = inputValue.trim();
            Integer result = Integer.valueOf(trimResult);
            converted.add(result);
        }

        lottoWinningNumbers.numbers = converted;
        return lottoWinningNumbers;
    }

    private static void validateInputWinningLottoNumbers(String[] spiltInput) {
        if (spiltInput.length != COUNT_OF_LOTTO_WINNING_NUMBERS) {
            throw new IllegalArgumentException("당첨 번호의 개수는 6개이어야 합니다.");
        }
    }
}
