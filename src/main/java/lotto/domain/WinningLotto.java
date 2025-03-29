package lotto.domain;

import java.util.List;

import static lotto.domain.PrizeLevel.getPrizeLevel;

public class WinningLotto {
    private final List<Integer> lottoNumbers;

    public WinningLotto(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public PrizeLevel countMatchingNumbers(Lotto lotto) {
        int count = (int) lottoNumbers.stream()
            .filter(lotto::containsNumber)
            .count();

        return getPrizeLevel(count);
    }
}
