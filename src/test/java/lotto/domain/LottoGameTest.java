package lotto.domain;

import lotto.strategy.AutoLotto;
import lotto.strategy.LottoStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {

    private static final int LOTTO_PRICE = 1000;

    private final List<List<Integer>> manualLottoNumbers = List.of(
            List.of(1, 2, 3, 4, 5, 6)
    );

    private final List<Lotto> lottoList = List.of(
            new Lotto(List.of(1, 2, 3, 4, 5, 6))
    );

    @Test
    @DisplayName("로또_구입_금액이_1000원_미만일_때_예외처리")
    void lottoBuyPrizeExceptionTest() {
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> new LottoGame(999));
    }

    @Test
    @DisplayName("로또_구입_금액이_1000원_이상일_때_로또_게임_객체_생성")
    void lottoBuyPrizeNormalTest() {
        // Given
        LottoGame lottoGame = new LottoGame(LOTTO_PRICE);

        // When & Then
        assertThat(lottoGame).isInstanceOf(LottoGame.class);
    }

    @Test
    @DisplayName("수동_로또_생성_테스트")
    void manualLottoDrawTest() {
        // Given
        LottoGame lottoGame = new LottoGame(LOTTO_PRICE);
        int numberOfManualCount = 1;
        Lottos lottos = lottoGame.manualLottoDraw(numberOfManualCount, manualLottoNumbers);

        // When & Then
        assertThat(lottos).isInstanceOf(Lottos.class);
    }

    @Test
    @DisplayName("자동_로또_생성_테스트")
    void automaticLottoDrawTest() {
        // Given
        LottoGame lottoGame = new LottoGame(LOTTO_PRICE);
        LottoStrategy strategy = new AutoLotto();
        Lottos lottos = lottoGame.automaticLottoDraw(strategy, lottoList);

        // When & Then
        assertThat(lottos).isInstanceOf(Lottos.class);
    }

    @Test
    @DisplayName("수동_로또_생성_후_자동_로또_생성_테스트")
    void manualAndAutomaticLottoDrawTest() {
        // Given
        LottoGame lottoGame = new LottoGame(LOTTO_PRICE);
        int numberOfManualCount = 1;
        Lottos lottos = lottoGame.manualLottoDraw(numberOfManualCount, manualLottoNumbers);
        LottoStrategy strategy = new AutoLotto();
        lottos = lottoGame.automaticLottoDraw(strategy, lottoList);

        // When & Then
        assertThat(lottos).isInstanceOf(Lottos.class);
    }
}