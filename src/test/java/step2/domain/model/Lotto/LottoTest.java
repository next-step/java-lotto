package step2.domain.model.Lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.domain.strategy.lotto.LottoPolicyStrategy;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
    private Lotto winningLotto;
    private Lotto randomLotto;

    @Test
    void 로또갯수_확인로직_체크() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(1));
        lottoNumbers.add(new LottoNumber(2));
        lottoNumbers.add(new LottoNumber(3));
        lottoNumbers.add(new LottoNumber(4));
        lottoNumbers.add(new LottoNumber(5));
        lottoNumbers.add(new LottoNumber(6));

        this.winningLotto = new Lotto(new LottoNumbers(lottoNumbers));

        List<LottoNumber> lottoNumbers2 = new ArrayList<>();
        lottoNumbers2.add(new LottoNumber(1));
        lottoNumbers2.add(new LottoNumber(2));
        lottoNumbers2.add(new LottoNumber(3));
        lottoNumbers2.add(new LottoNumber(4));
        lottoNumbers2.add(new LottoNumber(5));
        lottoNumbers2.add(new LottoNumber(7));
        this.randomLotto = new Lotto(new LottoNumbers(lottoNumbers2));

        randomLotto.calculatorLottoWinning(winningLotto);

        assertThat(randomLotto.getWinningCount()).isEqualTo(5);
    }
}
