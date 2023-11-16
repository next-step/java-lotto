package lotto.domain;

import java.util.List;

public class BonusBall {

    private final int bonusBall;

    public BonusBall(int bonusBall) {
        this.bonusBall = bonusBall;
    }

    public boolean containsBonusBall(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber == bonusBall);
    }
}
