package lotto;

import java.util.List;

public class ResultLotto {
    private int seedMoney;
    private List<Lotto> lottos;
    private int totalWinningAmount;

    public ResultLotto(int seedMoney, List<Lotto> buyLottos, int totalWinningAmount) {
        this.seedMoney = seedMoney;
        this.lottos = buyLottos;
        this.totalWinningAmount = totalWinningAmount;
    }

    public int totallottoCount() {
        return lottos.size();
    }

    public int getWinningAmount() {
        return totalWinningAmount;
    }

    public double getWinningRate() {
        return (double) totalWinningAmount / lottos.size() * 1000;
    }
}
