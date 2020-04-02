package lotto.controller;

import lotto.domain.LottoNumber;

import java.util.List;

public class LottoGame {
    public static int match(List<LottoNumber> lottoNumbers, List<LottoNumber> winningNumbers) {
        validateOfWinningNumbers(winningNumbers);
        int match = 0;
        for (int i = 0; i < winningNumbers.size(); i++) {
            match += contains(lottoNumbers, winningNumbers.get(i));
        }
        return match;
    }

    private static void validateOfWinningNumbers(List<LottoNumber> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private static int contains(List<LottoNumber> lottoNumbers, LottoNumber winningNumber) {
        if (lottoNumbers.contains(winningNumber)) {
            return 1;
        }
        return 0;
    }
}
