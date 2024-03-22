package lotto.domain;

import java.util.List;

import static lotto.domain.Rule.NUMBERS_OF_BALLS;

public class LottoNumbers {

    private final List<Integer> lottoNumbers;

    public LottoNumbers(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != NUMBERS_OF_BALLS.getValue()) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        this.lottoNumbers = lottoNumbers;
    }

    public int countMatchingWith(List<Integer> winningNumbers) {
        return Math.toIntExact(this.lottoNumbers.stream()
                .filter(winningNumbers::contains)
                .count());
    }

    public List<Integer> getLottoNumbers() {
        return this.lottoNumbers;
    }

}
