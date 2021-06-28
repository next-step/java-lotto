package lottogame.model;

import lottogame.service.LottoGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    LottoGame lottoGame = new LottoGame();

    @DisplayName("로또 생성 개수 테스트")
    @ParameterizedTest
    @CsvSource({"1000,1", "2000,2", "10000,10"})
    void getBuyCount(int buyPrice, int result) {
        assertThat(lottoGame.getBuyCount(buyPrice)).isEqualTo(result);
    }

    @DisplayName("로또 용지 생성 테스트 ")
    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "15,15"})
    void getLottoList(int buyCount, int result) {
        lottoGame.purchaseAutoLottoList(buyCount);
        assertThat(lottoGame.getLottos().getLottos().size()).isEqualTo(result);
    }

}
