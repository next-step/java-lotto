package lotto;

import java.util.Arrays;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusLottoNumber) {
        this.lotto = lotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public static WinningLotto of(Lotto lotto, LottoNumber lottoNumber) {
        return new WinningLotto(lotto, lottoNumber);
    }

    public LottoResult getResult(Lotto otherLotto) {
        int matchCount = otherLotto.getMatchCount(lotto);
        boolean isBonusMatched = otherLotto.contains(bonusLottoNumber);
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.getMatchCount() == matchCount)
                .filter(lottoResult -> lottoResult.getRequiresBonusMatch().matches(isBonusMatched))
                .findFirst()
                .orElse(LottoResult.NONE);
    }
}
