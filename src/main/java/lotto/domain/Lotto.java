package lotto.domain;

import lotto.strategy.ListSortOrMixStrategy;
import lotto.util.LottoNumberGenerator;

public class Lotto {
    private LottoNumbers lottoNumbers;
    private Award award = Award.UNIDENTIFIED;

    public Lotto(ListSortOrMixStrategy listSortOrMixStrategy) {
        lottoNumbers = LottoNumberGenerator.getLottoNumbers(listSortOrMixStrategy);
    }

    public void drawLotto(LottoNumbers winnerNumbers) {
        award = Award.findBy(lottoNumbers.sameAs(winnerNumbers));
    }

    public boolean isWinner(Award award) {
        return this.award == award;
    }

    public Award getAward() {
        return award;
    }

    public LottoNumbers getNumbers() {
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
