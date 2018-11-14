package net.chandol.lotto.util;

import net.chandol.lotto.domain.Lotto;
import net.chandol.lotto.value.LottoNumber;
import net.chandol.lotto.value.LottoNumberItem;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class ConsoleUiUtil {
    public static String formatLotto(Lotto lotto) {
        List<LottoNumberItem> lottoNumbers = lotto.getLottoNumber().getLottoNumbers();
        return lottoNumbers.stream()
                .map(String::valueOf)
                .collect(joining(", ", "[", "]"));
    }

    public static List<LottoNumber> getLottoNumbers(List<String> rawLottoNumbers) {
        return rawLottoNumbers.stream()
                .map(ConsoleUiUtil::getLottoNumber)
                .collect(toList());
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
