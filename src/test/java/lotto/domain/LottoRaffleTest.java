package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLotto;
import lotto.domain.lotto.number.BonusNumber;
import lotto.domain.lotto.number.Number;
import lotto.domain.lotto.number.Numbers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoRaffleTest {

    WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        final List<Number> numbersValues = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbersValues.add(new Number(i));
        }
        final Numbers numbers = new Numbers(numbersValues);
        final BonusNumber bonusNumber = new BonusNumber(7, numbers);
        this.winningLotto = new WinningLotto(numbers, bonusNumber);
    }

    @Test
    void 당첨_결과_확인() {
        final List<Number> numbersValues = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            numbersValues.add(new Number(i));
        }
        final Numbers numbers = new Numbers(numbersValues);
        Lotto lotto = new Lotto(numbers);
        LottoRaffle lottoRaffle = new LottoRaffle(winningLotto);
        lottoRaffle.compareLotto(lotto);

        for (LottoResult lottoResult : lottoRaffle.getResults().keySet()) {
            if (lottoResult == LottoResult.MATCH6) {
                assertThat(1).isEqualTo(lottoRaffle.getResults().get(lottoResult));
            } else {
                assertThat(0).isEqualTo(lottoRaffle.getResults().get(lottoResult));
            }
        }
    }
}