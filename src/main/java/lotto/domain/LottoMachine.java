package lotto.domain;

import lotto.domain.strategy.LottoStrategy;
import lotto.domain.winning.WinningStat;
import lotto.dto.LottoNumbersDto;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public int calculateUnitCount(Amount amount) {
        return amount.calculateUnitCount(LOTTO_PRICE);
    }

    /**
     * 돈을 받으면 로또를 만들어주는 책임은 로또 기계에 있다 판단하여 해당로직 작성
     */
    public Lottos makeLottos(Amount amount, LottoStrategy lottoStrategy) {
        return new Lottos(this.calculateUnitCount(amount), lottoStrategy);
    }

    public LottoNumbersDto lottoNumbersDto(Lottos lottos) {
        return lottos.lottoNumbersDto();
    }

    public Lotto winningLotto(String winningNumbers) {
        return Lotto.winningLotto(winningNumbers);
    }

    public LottoNumber bonusBall(int bonusBallNumber) {
        return new LottoNumber(bonusBallNumber);
    }

    public WinningStat winningStat(Lottos lottos, Lotto winningLotto, LottoNumber bonusBall) {
        return lottos.rating(winningLotto, bonusBall);
    }
}
