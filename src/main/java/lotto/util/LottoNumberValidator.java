package lotto.util;

import lotto.domain.Lotto;

import java.util.List;

public class LottoNumberValidator {
    private LottoNumberValidator() {
    }

    public static boolean isLottoNumbersUnique(List<Integer> lottoNumbers) {
        long numberOfUniqueNumbers = lottoNumbers.stream().distinct().count();
        return lottoNumbers.size() == numberOfUniqueNumbers;
    }

    public static boolean isLottoNumbersSizeCorrect(List<Integer> lottoNumbers) {
        return Lotto.LOTTO_NUMBERS_SIZE == lottoNumbers.size();
    }

    public static boolean isLottoNumbersCorrect(List<Integer> lottoNumbers) {
        long correctLottoNumbers = lottoNumbers.stream()
                .filter(LottoNumberValidator::isLottoNumberCorrect)
                .count();

        return correctLottoNumbers == lottoNumbers.size();
    }

    public static boolean isLottoNumberCorrect(int lottoNumber) {
        return (Lotto.MIN_NUMBER <= lottoNumber) && (lottoNumber <= Lotto.MAX_NUMBER);
    }
}
