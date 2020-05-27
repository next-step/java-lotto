package step2;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameTest {

    @DisplayName("로또 게임을 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 2000, 3000})
    void create(int purchasePrice) {
        LottoGame lottoGame = LottoGame.create(purchasePrice, new Random());
        assertThat(lottoGame.getPurchaseCount()).isEqualTo( purchasePrice / 1000);
    }
}