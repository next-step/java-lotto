package lotto.domain;

import lotto.domain.lotto.LottoNumber;
import lotto.exception.InvalidWinningNumbersException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.lotto.Lotto.LOTTO_NUMBER_SIZE;

public class WinningNumbers {
    private final Set<LottoNumber> winningNumbers;

    private WinningNumbers(List<Integer> winningNumbers) {
        validateSizeOfWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers.stream()
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());
    }

    private void validateSizeOfWinningNumbers(List<Integer> winningNumbers) {
        int sizeOfWinningNumbers = winningNumbers.size();
        int sizeOfWinningNumbersSet = new HashSet<>(winningNumbers).size();

        if(sizeOfWinningNumbers != sizeOfWinningNumbersSet || sizeOfWinningNumbers != LOTTO_NUMBER_SIZE) {
            throw InvalidWinningNumbersException.wrongSize();
        }
    }

    private WinningNumbers(Set<LottoNumber> winningNumbers) {
        validateSizeOfWinningNumbers(winningNumbers);
        this.winningNumbers = winningNumbers;
    }

    private void validateSizeOfWinningNumbers(Set<LottoNumber> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_SIZE) {
            throw InvalidWinningNumbersException.wrongSize();
        }
    }

    public static WinningNumbers valueOf(List<Integer> lottoNumbers) {
        return new WinningNumbers(lottoNumbers);
    }

    public static WinningNumbers valueOf(Set<LottoNumber> lottoNumbers) {
        return new WinningNumbers(lottoNumbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return winningNumbers.contains(lottoNumber);
    }
}
