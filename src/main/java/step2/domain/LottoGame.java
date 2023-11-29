package step2.domain;

import step2.generator.LottoNumbersMakeStrategy;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {

    private final List<Lotto> lottos;


    public LottoGame(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static LottoGame create(
            final int tryCount
            , final LottoNumbersMakeStrategy generator
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

    public Prizes game(List<Integer> prizeNumbers) {
        Prizes prizes = new Prizes();
        for (Lotto lotto : lottos) {
            getPrize(lotto, prizes, prizeNumbers);
        }
        return prizes;
    }

    private void getPrize(final Lotto lotto, final Prizes prizes, List<Integer> prizeNumbers) {
        List<Integer> prizeNumbers1 = new ArrayList<>();
        for (Integer number : lotto.getNumbers()) {
            getPrizeNumbers(number, prizeNumbers1);
        }
        prizes.winPrize(new Prize(prizeNumbers1.size()));
    }

    private List<Integer> getPrizeNumbers(int number,  List<Integer> prizeNumbers) {
        if (prizeNumbers.contains(number)) {
            prizeNumbers.add(number);
        }
        return prizeNumbers;
    }
}
