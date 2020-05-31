package com.lotto.helper;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoViewHelper {

    private static final String LOTTO_NUMBER_SPLIT_SYMBOL = ",";
    public static final Integer COUNT_OF_LOTTO_NUMBERS = 6;
    private static final Integer PRIZE_OF_LOTTO = 1000;

    public static Integer getCountOfLotto(Integer depositMoney) {
        return depositMoney / PRIZE_OF_LOTTO;
    }

    public static Integer getPurchaseAmountOfLotto(Integer purchaseCount) {
        return purchaseCount * PRIZE_OF_LOTTO;
    }

    public static List<Integer> manipulateInputLottoNumbers(String input) {

        String[] splitInput = StringUtils.split(input, LOTTO_NUMBER_SPLIT_SYMBOL);
        validateInputWinningLottoNumbers(splitInput);

        List<Integer> converted = new ArrayList<>();
        for (String inputValue : splitInput) {
            String trimResult = inputValue.trim();
            Integer result = Integer.valueOf(trimResult);
            converted.add(result);
        }

        return converted;
    }

    private static void validateInputWinningLottoNumbers(String[] spiltInput) {
        if (spiltInput.length != COUNT_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("당첨 번호의 개수는 6개이어야 합니다.");
        }
    }
}
