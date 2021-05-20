package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {
    private List<LottoNumber> lottoNumbers = Arrays.asList(
            new LottoNumber(1), new LottoNumber(2),
            new LottoNumber(3), new LottoNumber(4),
            new LottoNumber(5), new LottoNumber(6)
    );

    private GameResult gameResult;
    private Lotto lotto;
    private Lotto winningLotto;

    @BeforeEach
    void setUp() {
        gameResult = new GameResult();
        gameResult.addWinResult(Prize.FOURTH);

        lotto = new Lotto(lottoNumbers);
        winningLotto = new Lotto(lottoNumbers);
    }

    @DisplayName("로또 게임의 총 수익률을 리턴한다.")
    @Test
    void getGameProfit() {
        // given
        final Money purchasedAmount = new Money(20_000);

        // when
        double actual = gameResult.getProfit(purchasedAmount);

        // then
        assertThat(actual).isEqualTo(0.25);
    }

    @Test
    void matchLottoNumber() {
        assertThat(gameResult.getPrizeMatch(lotto, winningLotto)).isSameAs(Prize.FIRST);
    }
}
