package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Rank.*;

public class LottoCenter {

    public static final int PRICE = 1000;

    private final List<Long> result = new ArrayList<>();
    private static int cash;

    public List<Lotto> buyLotto(int cash) {
        LottoCenter.cash = cash;
        return generateTicket(cash);
    }

    private List<Lotto> generateTicket(int cash) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cash / PRICE; i++) {
            Lotto lotto = new Lotto();
            lottos.add(lotto);
        }
        return lottos;
    }

    public void matchWinningNumbers(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            lotto.matchCount(winningNumbers, bonusNumber);
        }
    }

    public List<Long> checkWinningResult(List<Lotto> lottos) {
        for (Rank rank : values()) {
            result.add(lottos.stream()
                    .filter(lotto -> Rank.valueOf(lotto).equals(rank)).count());
        }
        return result;
    }

    public float checkWinningRate() {
        return (float) ((result.get(0) * FIRST.getWinningMoney())
                + (result.get(1) * SECOND.getWinningMoney())
                + (result.get(2) * THIRD.getWinningMoney())
                + (result.get(3) * FOURTH.getWinningMoney())
                + (result.get(4) * FIFTH.getWinningMoney())) / cash;
    }
}
