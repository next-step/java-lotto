package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.NumberStrategy;

public class WinningLotto extends Lotto {

    private final LottoNumber bonusBall;

    public WinningLotto(NumberStrategy numberStrategy, int bonusBall) {
        super(numberStrategy);
        checkBonusBall(bonusBall);
        this.bonusBall = LottoNumber.of(bonusBall);
    }

    public LottoResult lottoResult(List<Lotto> lottos) {
        return new LottoResult(matchResults(lottos));
    }

    public List<MatchResult> matchResults(List<Lotto> lottos) {
        List<MatchResult> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            result.add(new MatchResult(matchCount(lotto), matchBonusBall(lotto)));
        }
        return result;
    }

    private int matchCount(Lotto lotto) {
        int matchNumber = 0;
        for (int i = 0; i < lotto.getLottoNumber().size(); i++) {
            matchNumber += checkMatch(lotto.getLottoNumber(), i);
        }
        return matchNumber;
    }

    private boolean matchBonusBall(Lotto lotto) {
        return lotto.getLottoNumber().contains(bonusBall);
    }

    private int checkMatch(List<LottoNumber> lottoNumber, int num) {
        return super.getLottoNumber().contains(lottoNumber.get(num)) ? 1 : 0;
    }

    private void checkBonusBall(int bonusBall) {
        if (getLottoNumber().contains(bonusBall)) {
            throw new IllegalStateException("보너스 볼은 당첨번호에 포함되지 않아야 합니다.");
        }
    }

}
