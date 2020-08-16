package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import strategy.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoGameTest {
    @DisplayName("구입 가격에서 로또 1장의 가격 1000에 맞추어 구매 수량을 생성")
    @ParameterizedTest
    @CsvSource({"1000,1", "11111, 11", "500,0"})
    void lottoGame(int buyPrice, int buyAmount) {
        LottoGame lottoGame = new LottoGame(buyPrice);

        assertThat(lottoGame.getBuyAmount()).isEqualTo(buyAmount);
    }

    @DisplayName("구매 수량에 맞추어 로또를 발행")
    @Test
    void issue() {
        LottoGame lottoGame = new LottoGame(10000);

        Lottos issuedLottos = lottoGame.issue(new RandomNumberGenerator());

        assertThat(issuedLottos.getLottos()).hasSize(10);

    }
}
