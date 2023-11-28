package step2.domain;

import step2.generator.LottoNumbersStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final List<Lotto> lottos;


    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoGame create(
            final int tryCount
            , final LottoNumbersStrategy generator
    ) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            lottoList.add(Lotto.create(generator.generate()));
        }
        return new LottoGame(lottoList);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public WinPrizes game(List<Integer> prizeNumbers) {
        WinPrizes winPrizes = new WinPrizes();
        for (Lotto lotto : lottos) {
            getPrize(lotto, winPrizes, prizeNumbers);
        }
        return winPrizes;
    }

    private void getPrize(final Lotto lotto, final WinPrizes winPrizes, List<Integer> prizeNumbers) {
        List<Integer> getNumbers = new ArrayList<>();
        for (Integer number : lotto.getNumbers()) {
            if (prizeNumbers.contains(number)) {
                getNumbers.add(number);
            }
        }
        winPrizes.winPrize(new Prize(getNumbers.size()));
    }
}
