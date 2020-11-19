package step02.domain;

import exception.LottoNumberException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberTokenizer {
    private static String TOKEN = ", ";

    public static List<LottoNumber> execute(String winningNumbers, LottoGenerator lottoGenerator) {
        List<LottoNumber> lottoNumbers = Arrays.stream(winningNumbers.split(TOKEN))
                .map(inputNumber -> {
                    Integer number = Integer.parseInt(inputNumber);
                    validateNumber(lottoGenerator, number);
                    return LottoNumber.of(number);
                })
                .collect(Collectors.toList());
        return lottoNumbers;
    }

    private static void validateNumber(LottoGenerator lottoGenerator, Integer number) {
        if (!lottoGenerator.isValidNumber(number)) {
            throw new LottoNumberException();
        }
    }


}
