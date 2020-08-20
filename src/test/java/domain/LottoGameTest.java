package domain;

import exception.LottoGamePriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import strategy.RandomLottoNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LottoGameTest {
    @DisplayName("구입 가격에서 로또 1장의 가격 1000에 맞추어 구매 수량을 생성")
    @ParameterizedTest
    @CsvSource({"1000,1", "11111, 11"})
    void lottoGame(int buyPrice, int buyAmount) {
        LottoGame lottoGame = LottoGame.of(buyPrice, 0);

        assertThat(lottoGame.getAutoCount()).isEqualTo(buyAmount);
    }

    @DisplayName("구입 가격에서 로또 1장의 가격 1000에 맞추어 수동 게임 및 자동 게임 수량 생성")
    @ParameterizedTest
    @CsvSource({"1000, 1, 0, 1", "11111, 2, 9, 2"})
    void lottoGame_passivity(int buyPrice, int passivityCount, int autoCount, int createdPassivityCount) {
        LottoGame lottoGame = LottoGame.of(buyPrice, passivityCount);

        assertThat(lottoGame.getAutoCount()).isEqualTo(autoCount);
        assertThat(lottoGame.getPassivityCount()).isEqualTo(createdPassivityCount);
    }

    @DisplayName("구입가격이 로또 1장의 가격보다 작거나, 구입가격이 수동 생성 로또 가격보다 작으면 exception 발생")
    @ParameterizedTest
    @CsvSource({"500, 0", "0, 0", "1000, 2"})
    void lottoGame_invalidBuyPrice(int buyPrice, int passivityCount) {
        assertThatThrownBy(() -> LottoGame.of(buyPrice, passivityCount)).isInstanceOf(LottoGamePriceException.class);
    }

    @DisplayName("구매 수량에 맞추어 로또를 발행")
    @Test
    void issue() {
        LottoGame lottoGame = LottoGame.of(10000, 0);

        Lottos issuedLottos = lottoGame.issue(new RandomLottoNumberGenerator());

        assertThat(issuedLottos.getLottos()).hasSize(10);

    }
}
