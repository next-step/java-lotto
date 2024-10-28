package lotto.domain;

import java.util.List;

public class WinningLotto {

    private final LottoNumber bonusNumber;
    private final Lotto lotto;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        LottoNumber lottoNumber = new LottoNumber(bonusNumber);
        if (lotto.containNumber(lottoNumber)) {
            throw new IllegalArgumentException("올바르지 않은 입력 입니다.");
        }
        this.lotto = lotto;
        this.bonusNumber = lottoNumber;
    }

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        this(new Lotto(numbers), bonusNumber);
    }

    public static WinningLotto of(String value, int bonusNumber) {
        return new WinningLotto(Lotto.from(value), bonusNumber);
    }

    public Rank match(Lotto lotto) {
        return LottoRank.match(matchCount(lotto), hasBonusNumber(lotto));
    }

    private boolean hasBonusNumber(Lotto lotto) {
        return lotto.containNumber(bonusNumber);
    }

    private int matchCount(Lotto lotto) {
        return this.lotto.matchCount(lotto);
    }
}
