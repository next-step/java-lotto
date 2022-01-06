package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.utils.NumberStrategy;

public class WinningLotto extends Lotto {

    private final int bonusBall;

    public WinningLotto(NumberStrategy numberStrategy, int bonusBall) {
        super(numberStrategy);
        super.checkNumber(bonusBall);
        this.bonusBall = bonusBall;
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

    private int checkMatch(List<Integer> lottoNumber, int num) {
        return super.getLottoNumber().contains(lottoNumber.get(num)) ? 1 : 0;
    }

}
