package step2.iksoo.lottoAuto;

import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottoList) {
        this.lottos = lottoList;
        this.printLotto();
    }

    protected void printLotto() {
        IntStream.range(0, this.lottos.size())
                .forEach(n -> this.lottos.get(n).printLotto());
        OutputView.printBlankLine();
    }

    protected int[] checkLotteryWin(List<Integer> winnerNumbers) {
        int[] wonLotterys = new int[winnerNumbers.size() + 1];
        this.lottos
                .stream()
                .map(lotto -> {
                    return lotto.checkNumberOfMatches(winnerNumbers);
                })
                .forEach(x -> wonLotterys[x]++);
        return wonLotterys;
    }

    protected double calculateRateProfit(int amoutPrize) {
        return Math.round((amoutPrize / this.lottos.size() / 1000.0) * 100.0) / 100.0;
    }
}
