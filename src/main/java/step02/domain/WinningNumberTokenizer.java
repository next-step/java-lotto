package step02.domain;

import exception.OutOfLottoNumberRangeException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberTokenizer {
    private static final String TOKEN = ", ";

    public static List<LottoNumber> execute(String winningNumbers, LottoGenerator lottoGenerator) {
        return Arrays.stream(winningNumbers.split(TOKEN))
                .map(inputNumber -> {
                    Integer number = Integer.parseInt(inputNumber);
                    validateNumberRange(lottoGenerator, number);
                    return LottoNumber.of(number);
                })
                .collect(Collectors.toList());
    }

    private static void validateNumberRange(LottoGenerator lottoGenerator, Integer number) {
        if (!lottoGenerator.isValidNumberRange(number)) {
            throw new OutOfLottoNumberRangeException();
        }
    }

}
