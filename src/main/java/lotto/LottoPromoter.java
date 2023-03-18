package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoPromoter {

    public final static LottoGrade.LOTTO_GRADE checkLottoGrade(Lotto lotto, Lotto winningLotto, LottoBall bonusBall) {
        boolean hasBonusBall = lotto.getBalls().contains(bonusBall);
        long matchCount = lotto.getBalls().stream()
                .filter(ball -> winningLotto.getBalls().contains(ball) && ball != bonusBall)
                .count();

        return LottoGrade.getLottoGrade(matchCount, hasBonusBall);
    }

    public final static List<LottoGrade.LOTTO_GRADE> checkLottoGrades(List<Lotto> lottos, Lotto winningLotto, LottoBall bonusBall) {
        List<LottoGrade.LOTTO_GRADE> lottoGrades = new ArrayList<>();
        lottos.stream()
                .forEach(lotto -> {
                    LottoGrade.LOTTO_GRADE grade = checkLottoGrade(lotto, winningLotto, bonusBall);
                    lottoGrades.add(grade);
                });
        return lottoGrades;
    }
}
