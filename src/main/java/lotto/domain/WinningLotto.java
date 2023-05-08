package lotto.domain;

import java.util.List;

public class WinningLotto extends Lotto{
    private Integer bonusNumber;

    public WinningLotto(List<Integer> inNumbers, Integer inBonusNumber) {
        super(inNumbers);
        bonusNumber = inBonusNumber;
    }

    public int countMatchingWith(Lotto inLotto) {
        return (int) numbers.stream()
                .filter(inLotto::contains)
                .count();
    }

    public boolean containsBonus(Lotto inLotto) {
        return inLotto.contains(bonusNumber);
    }
}
