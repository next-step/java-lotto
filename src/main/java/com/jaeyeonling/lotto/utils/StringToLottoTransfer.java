package com.jaeyeonling.lotto.utils;

import com.jaeyeonling.lotto.domain.Lotto;
import com.jaeyeonling.lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public final class StringToLottoTransfer {

    private static final String LOTTO_NUMBER_SEPARATOR = ",";

    private StringToLottoTransfer() { }

    public static Lotto transform(final String stringLottoNumbers) {
        final Set<LottoNumber> lottoNumbers = Arrays.stream(splitWinningLottoNumber(stringLottoNumbers))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());

        return new Lotto(lottoNumbers);
    }

    private static String[] splitWinningLottoNumber(final String winningLottoNumber) {
        return winningLottoNumber.split(LOTTO_NUMBER_SEPARATOR);
    }
}
