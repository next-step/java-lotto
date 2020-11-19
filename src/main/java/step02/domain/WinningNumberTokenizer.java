package step02.domain;

import exception.LottoNumberDuplicatedException;
import exception.LottoNumberException;
import exception.LottoSizeException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumberTokenizer {
    private static String TOKEN = ", ";

    public static List<LottoNumber> execute(String winningNumbers, LottoGenerator lottoGenerator) {
        List<LottoNumber> lottoNumbers = Arrays.stream(winningNumbers.split(TOKEN))
                .map(inputNumber -> {
                    Integer number = Integer.parseInt(inputNumber);
                    validateNumberRange(lottoGenerator, number);
                    return LottoNumber.of(number);
                })
                .collect(Collectors.toList());
                validateLottoSize(lottoNumbers);
                validateUniqueNumber(lottoNumbers);
        return lottoNumbers;
    }

    private static void validateNumberRange(LottoGenerator lottoGenerator, Integer number) {
        if (!lottoGenerator.isValidNumberRange(number)) {
            throw new LottoNumberException();
        }
    }

    private static void validateUniqueNumber(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != new HashSet<>(lottoNumbers).size()) {
            throw new LottoNumberDuplicatedException();
        };
    }

    private static void validateLottoSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new LottoSizeException();
        }
    }
}
