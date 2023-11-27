package domain;

import generator.LottoNumbersGenerator;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final List<Lotto> lottos;

    private final List<Integer> prizeNumbers;

    public LottoGame(List<Lotto> lottos, List<Integer> prizeNumbers) {
        this.lottos = lottos;
        this.prizeNumbers = prizeNumbers;
    }

    public static LottoGame create(
            final int tryCount
            , final LottoNumbersGenerator generator
            , final List<Integer> prizeNumbers
    ) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < tryCount; i++) {
            lottoList.add(Lotto.create(generator));
        }
        return new LottoGame(lottoList, prizeNumbers);
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    public WinPrizes game(final Prize prize) {
        WinPrizes winPrizes = new WinPrizes();
        for (Lotto lotto : lottos) {
            winPrizes.winPrize(getPrize(lotto));
        }
        return winPrizes;
    }

    private Prize getPrize(final Lotto lotto) {
        List<Integer> getNumbers = new ArrayList<>();
        for (Integer number : lotto.getNumbers()) {
            if (prizeNumbers.contains(number)) {
                getNumbers.add(number);
            }
        }
        return new LottoPrize(getNumbers.size());
    }
}
