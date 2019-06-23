package step2.iksoo.lottoAuto;

import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public int[] checkLotteryWin(List<Integer> winnerNumbers) {
        int[] wonLotterys = new int[winnerNumbers.size() + 1];
        this.lottos
                .stream()
                .map(lotto -> lotto.checkNumberOfMatches(winnerNumbers))
                .forEach(x -> wonLotterys[x]++);
        return wonLotterys;
    }

    public double calculateRateProfit(int amoutPrize) {
        return Math.round((amoutPrize / this.lottos.size() / 1000.0) * 100.0) / 100.0;
    }
}
