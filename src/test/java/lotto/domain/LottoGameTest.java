package lotto.domain;

import lotto.strategy.AutoLotto;
import lotto.strategy.LottoStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameTest {


    @Test
    @DisplayName("로또_구입_금액이_1000원_미만일_때_예외처리")
    void lottoBuyPrizeExceptionTest() {
        // When & Then
        assertThrows(IllegalArgumentException.class, () -> new LottoGame(999));
    }

    @Test
    @DisplayName("로또_구입_금액이_1000원_이상일_때_로또_갯수_확인")
    void test() {
        // Given
        LottoGame lottoGame = new LottoGame(1000);
        LottoStrategy lottoStrategy = new AutoLotto();

        // When & Then
        assertThat(lottoGame.automaticLottoDraw(lottoStrategy).getLottoList()).hasSize(1);
    }
}