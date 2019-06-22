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
        int[] lottoPrize = new int[winnerNumbers.size()+1];
        this.lottos
                .stream()
                .map(lotto -> {return lotto.checkNumberOfMatches(winnerNumbers);})
                .forEach(x-> lottoPrize[x]++);
        return lottoPrize;
    }
}
