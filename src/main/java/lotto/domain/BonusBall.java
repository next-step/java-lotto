package lotto.domain;

import java.util.List;

public class BonusBall {

    private final int bounsBall;

    public BonusBall(int bounsBall) {
        this.bounsBall = bounsBall;
    }

    public boolean containsBonusBall(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .anyMatch(lottoNumber -> lottoNumber == bounsBall);
    }
}
