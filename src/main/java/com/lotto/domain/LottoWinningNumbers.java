package com.lotto.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumbers {

    private static final String WINNING_LOTTO_NUMBER_SPLIT_SYMBOL = ",";

    private List<Integer> lottoWinningNumbers;

    public void manipulateInputWinningLottoNumbers(String input) {
        String[] splitInput = StringUtils.split(input, WINNING_LOTTO_NUMBER_SPLIT_SYMBOL);
        List<Integer> converted = new ArrayList<>();
        for (String inputValue : splitInput) {
            Integer result = Integer.valueOf(inputValue);
            converted.add(result);
        }

        this.lottoWinningNumbers = converted;
    }
}
