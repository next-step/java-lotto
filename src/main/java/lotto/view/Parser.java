package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.WinningNumbers;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Parser {
    public static WinningNumbers parseWinningNumbers(String input, LottoNumber bonusNumber) {
        return new WinningNumbers(parseNumberSet(input), bonusNumber);
    }

    public static Set<LottoNumber> parseNumberSet(String input) {
        String[] tokens = input.split(",");

        return Arrays.stream(tokens)
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}
