package net.chandol.lotto.util;

import net.chandol.lotto.domain.Lotto;
import net.chandol.lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ConsoleUiUtil {
    public static String formatLotto(Lotto lotto) {
        List<Integer> lottoNumbers = lotto.getLottoNumbers();
        return lottoNumbers.stream()
                .map(String::valueOf)
                .collect(joining(", ", "[", "]"));
    }

    public static LottoNumber getLottoNumber(String rawLottoNumber) {
        String[] rawLottoNumbers = rawLottoNumber.split(",");
        List<Integer> numbers = Arrays.stream(rawLottoNumbers)
                .peek(String::trim)
                .map(Integer::valueOf)
                .collect(toList());

        return LottoNumber.direct(numbers);
    }
}
