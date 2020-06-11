package step2.model;

import step2.exception.LottoDuplicateNumberException;
import step2.exception.LottoLengthException;
import step2.exception.LottoOutOfBoundException;

import java.util.List;

public class LottoNumber {

    private LottoNumber() {};

    public static void validateNumbers(List<Integer> lottoNumbers) {
        checkNumber(lottoNumbers);
        checkSize(lottoNumbers);
        countWithoutDuplication(lottoNumbers);
    }

    private static void checkNumber(List<Integer> lottoNumbers) {
        lottoNumbers.stream()
                .filter(number -> number > Lotto.MAX || number < Lotto.MIN)
                .findAny()
                .ifPresent(number -> {
                    throw new LottoOutOfBoundException();
                });
    }

    private static void checkSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != Lotto.SIZE) {
            throw new LottoLengthException();
        }
    }

    private static void countWithoutDuplication(List<Integer> lottoNumbers) {
        int cnt = (int) lottoNumbers.stream()
                .distinct()
                .count();

        if (cnt != Lotto.SIZE) {
            throw new LottoDuplicateNumberException();
        }
    }
}
