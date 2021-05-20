package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

class GameResultTest {
    private List<LottoNumber> lottoNumbers = Arrays.asList(
            new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4),
            new LottoNumber(5), new LottoNumber(6)
    );

    private GameResult gameResult;
    private Lotto lotto;
    private Lotto winningLotto;
    private LottoNumber bonusNumber;
    private LottoNumber duplicatedNumber;

    @BeforeEach
    void setUp() {
        gameResult = new GameResult();
        gameResult.addWinResult(Prize.FOURTH);

        lotto = new Lotto(lottoNumbers);
        winningLotto = new Lotto(lottoNumbers);
        bonusNumber = new LottoNumber(7);
        duplicatedNumber = new LottoNumber(1);
    }

    @DisplayName("로또 게임의 총 수익률을 리턴한다.")
    @Test
    void getGameProfit() {
        // given
        final Money purchasedAmount = new Money(20_000);

        // when
        double actual = gameResult.getProfit(purchasedAmount);

        // then
        assertThat(actual).isEqualTo(2.5);
    }

    @Test
    void matchLottoNumber() {
        assertThat(gameResult.getPrizeMatch(lotto, winningLotto, bonusNumber)).isSameAs(Prize.FIRST);
    }

    @DisplayName("당첨번호와 보너스 번호 중복시 예외를 던진다")
    @Test
    void bonusNumberDuplicated() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> gameResult.getPrizeMatch(lotto, winningLotto, duplicatedNumber));
    }
}
