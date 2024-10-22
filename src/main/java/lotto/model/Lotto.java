package lotto.model;

import java.util.List;

public class Lotto {
    private List<Integer> number;

    public Lotto(List<Integer> lottoNumber) {
        this.number = lottoNumber;
    }

    public int countMatchingNumber(List<Integer> winningNumbers) {
        return (int) number.stream()
                .filter(winningNumbers::contains)
                    .count();
    }

    public boolean containsBonusNumber(int bonusNumber) {
        return number.contains(bonusNumber);
    }
}
