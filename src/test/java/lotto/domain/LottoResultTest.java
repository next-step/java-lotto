package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    private WinningLotto winningLotto;
    private LottoNumbers lottoNumbers;
    private LottoNumber bonusBall;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        bonusBall = LottoNumber.valueOf(7);
        winningLotto = WinningLotto.of(lottoNumbers, bonusBall);
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void ratio() {
        LottoNumbers purchase = new LottoNumbers("1, 2, 3, 7, 8, 9");
        LottoResult lottoResult = new LottoResult();
        lottoResult.rank(purchase, winningLotto);

        final double actual = lottoResult.ratio(new Price(14000));

        assertThat(actual).isEqualTo(0.35);
    }
}