package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Rank.*;

public class LottoCenter {

    public static final int PRICE = 1000;

    private static int cash;
    private WinningLotto winningLotto;
    private List<Rank> result;

    public LottoCenter() {
    }

    public LottoCenter(WinningLotto winningLotto) {
        this.winningLotto = winningLotto;
    }

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

    public List<Rank> matchWinningNumbers(List<Lotto> lottos) {
        List<Rank> checkedResult = new ArrayList<>();
        for (Lotto lotto : lottos) {
            checkedResult.add(winningLotto.matchRank(lotto));
        }
        this.result = checkedResult;
        return this.result;
    }

    public List<Integer> checkWinningResult() {
        List<Integer> statistic = new ArrayList<>();
        for (Rank value : values()) {
            int count = (int) result.stream().filter(n -> n.equals(value)).count();
            statistic.add(count);
        }
        return statistic;
    }

    public float checkWinningRate() {
        int sum = 0;
        for (Rank value : values()) {
            int count = (int) result.stream().filter(n -> n.equals(value)).count();
            sum = sum + count * value.getWinningMoney();
        }
        return (float) sum / cash;
    }
}
