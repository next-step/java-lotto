package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningLottoTest {

    private WinningLotto winningLotto;
    private LottoNumbers lottoNumbers;
    private LottoNumber bonusBall;

    @BeforeEach
    void setUp() {
        lottoNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        bonusBall = LottoNumber.valueOf(7);
        winningLotto = WinningLotto.of(lottoNumbers, bonusBall);
    }

    @DisplayName("당첨 번호 객체를 생성할 수 있다.")
    @Test
    void create() {
        WinningLotto actual = WinningLotto.of(new LottoNumbers("1, 2, 3, 4, 5, 6"), LottoNumber.valueOf(7));

        assertThat(actual).isEqualTo(winningLotto);
    }

    @DisplayName("구매한 복권들과 당첨 복권이 일치하지 않는다.")
    @Test
    void matchBlank() {
        LottoNumbers purchase = new LottoNumbers("7, 8, 9, 10, 11, 12");

        LottoRank actual = winningLotto.match(purchase);

        assertThat(actual).isEqualTo(LottoRank.BLANK);
    }

    @DisplayName("구매한 복권들과 당첨 복권이 3개 일치한다. (4등)")
    @Test
    void matchFourth() {
        LottoNumbers purchase = new LottoNumbers("1, 2, 3, 10, 11, 12");

        LottoRank actual = winningLotto.match(purchase);

        assertThat(actual).isEqualTo(LottoRank.FOURTH);
    }

    @DisplayName("구매한 복권들과 당첨 복권이 4개 일치한다. (3등)")
    @Test
    void matchThird() {
        LottoNumbers purchase = new LottoNumbers("1, 2, 3, 4, 11, 12");

        LottoRank actual = winningLotto.match(purchase);

        assertThat(actual).isEqualTo(LottoRank.THIRD);
    }

    @DisplayName("구매한 복권들과 당첨 복권이 5개 일치한다. (2등)")
    @Test
    void matchSecond() {
        LottoNumbers purchase = new LottoNumbers("1, 2, 3, 4, 5, 12");

        LottoRank actual = winningLotto.match(purchase);

        assertThat(actual).isEqualTo(LottoRank.SECOND);
    }

    @DisplayName("구매한 복권들과 당첨 복권이 5개 + 보너스 볼이 일치한다. (2등 보너스)")
    @Test
    void matchSecondBonus() {
        LottoNumbers purchase = new LottoNumbers("1, 2, 3, 4, 5, 7");

        LottoRank actual = winningLotto.match(purchase);

        assertThat(actual).isEqualTo(LottoRank.SECOND_BONUS);
    }

    @DisplayName("구매한 복권들과 당첨 복권이 6개 일치한다. (1등)")
    @Test
    void analyzeWin_First() {
        LottoNumbers purchase = new LottoNumbers("1, 2, 3, 4, 5, 6");

        LottoRank actual = winningLotto.match(purchase);

        assertThat(actual).isEqualTo(LottoRank.FIRST);
    }
}