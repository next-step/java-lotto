package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNum bonusNum;

    public WinningLotto(Lotto lotto, int bonusNum) {
        validateBonusNum(lotto, bonusNum);
        this.lotto = lotto;
        this.bonusNum = new LottoNum(bonusNum);
    }

    public WinningLotto(List<Integer> winningNums, int bonusNum) {
        this(Lotto.of(winningNums), bonusNum);
    }

    public LottoPrize getPrize(Lotto lotto) {
        int matchCount = lotto.getMatchCount(this.lotto);
        boolean bonusMatch = lotto.match(bonusNum);
        return LottoPrize.valueOf(matchCount, bonusMatch);
    }

    private static void validateBonusNum(Lotto lotto, int bonusNum) {
        if (lotto.match(new LottoNum(bonusNum))) {
            throw new IllegalArgumentException(String.format("보너스볼 %d는 로또번호 %s와 중복될 수 없습니다.", bonusNum, lotto.toString()));
        }
    }
}
