package lotto.domain;

import java.util.stream.Collectors;

public class WinningLotto {

    private final Lotto numbers;
    private final LottoNumber bonusBall;

    private WinningLotto(Lotto numbers, LottoNumber bonusBall) {
        this.numbers = numbers;
        this.bonusBall = bonusBall;
    }

    public static WinningLotto of(String number, int bonusBall) {
        return new WinningLotto(Lotto.of(number), LottoNumber.of(bonusBall));
    }

    Rank matchRank(Lotto lotto) {
        return Rank.of(matchCount(lotto), hasBonusBall(lotto));
    }

    private boolean hasBonusBall(Lotto lotto) {
        return lotto.stream()
                .anyMatch(number -> number.equals(bonusBall));
    }

    private boolean hasNumber(LottoNumber lottoNumber) {
        return numbers.stream()
                .anyMatch(number -> number.equals(lottoNumber));
    }

    private int matchCount(Lotto lotto) {
        return lotto.stream()
                .filter(this::hasNumber)
                .collect(Collectors.toList())
                .size();
    }
}
