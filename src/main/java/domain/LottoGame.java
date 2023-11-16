package domain;

import java.util.Map;

public class LottoGame {

    private final UserLotto userLotto;

    public LottoGame(UserLotto userLotto) {
        this.userLotto = userLotto;
    }

    public Map<Integer, Integer> matchNumbers(WinningLotto winningLotto) {

        return userLotto.matchUserLotto(winningLotto);
    }

    public float calculateReturnRate(Long money, Map<Integer, Integer> lottoPrizeIntegerMap) {
        long prizeSum = 0;
        for (Map.Entry<Integer, Integer> entry : lottoPrizeIntegerMap.entrySet()) {
            prizeSum += LottoPrize.fromMatchCount(entry.getKey()).winningPrize() * entry.getValue();
        }
        return (float) prizeSum / money;
    }
}
