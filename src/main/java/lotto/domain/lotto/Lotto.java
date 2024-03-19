package lotto.domain.lotto;

import lotto.domain.WinningNumbers;

import java.util.List;

public class Lotto {
    public static final int LOTTO_NUMBER_SIZE = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> lottoNumbers;

    private Lotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto valueOf(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public int countOfMatch(WinningNumbers winningNumbers) {
        return (int) lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public List<Integer> lottoNumbers() {
        return lottoNumbers;
    }
}
