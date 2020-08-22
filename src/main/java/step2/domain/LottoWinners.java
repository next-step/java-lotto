package step2.domain;

import java.util.List;

public class LottoWinners {
    public final Lottos lottos;
    public final List<Integer> winningNumbers;

    public LottoWinners(Lottos lottos, List<Integer> winningNumbers) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
    }

    public int[] getWinner() {

        return lottos.getLottos().mapToInt(lotto -> {
            lotto.getLotto().retainAll(this.winningNumbers);
            return lotto.getLotto().size();
        }).sorted().toArray();
    }
}
