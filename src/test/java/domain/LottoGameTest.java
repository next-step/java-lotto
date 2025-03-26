package domain;

import domain.lotto.Rank;
import domain.lotto.WinningLotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

public class LottoGameTest {

    private static final WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6));

    @DisplayName("구매 금액에 해당하는 갯수의 로또 발급")
    @CsvSource(value = {"1000, 1000, 1", "14000, 2000, 7", "5000, 5000, 1"})
    @ParameterizedTest
    void createLotto(int purchaseAmount, int lottoPrice, int expected) {
        // when
        LottoGame lottoGame = new LottoGame(purchaseAmount, lottoPrice, winningLotto);

        // then
        Assertions.assertThat(lottoGame.getLottoCount()).isEqualTo(expected);
    }

    @DisplayName("로또 구입 금액이 로또 1개 가격 단위가 아니거나 1개 가격 이하인 경우 IllegalArgumentException throw")
    @CsvSource(value={"0, 500", "500, 1000", "1500, 1000"})
    @ParameterizedTest
    void createLottoException(int purchaseAmount, int lottoPrice) {
        // when
        Assertions.assertThatThrownBy(() -> new LottoGame(purchaseAmount, lottoPrice, winningLotto))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 결과 반환")
    @Test
    void playLotto() {
        int purchaseAmount = 10000;
        int lottoPrice = 1000;

        LottoGame lottoGame = new LottoGame(purchaseAmount, lottoPrice, winningLotto);
        LottoGameResult result = lottoGame.play();

        int actual = 0;
        for (Rank rank: Rank.values()) {
            actual += result.getRankCounters().getCount(rank);
        }
        Assertions.assertThat(actual).isEqualTo(lottoGame.getLottoCount());
    }
}
