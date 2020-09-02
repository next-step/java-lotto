package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGameTest {

    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        int purchaseAmount = 3500;
        lottoGame = LottoGame.of(purchaseAmount);
    }

    @DisplayName("로또 구입 금액 유효성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {900})
    void invalidPurchaseAmount(int purchaseAmount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoGame.of(purchaseAmount))
                .withMessage("로또 구입 금액이 부족합니다.");
    }

    @DisplayName("로또 개수 테스트")
    @Test
    void getLottoCountByPurchaseAmount() {
        assertThat(lottoGame.getCount()).isEqualTo(3);
    }

    @Test
    void makeLottos() {
        Lottos lottos = lottoGame.makeLottos(new LottoNumberRandomGenerator());
        assertThat(lottos.size()).isEqualTo(3);
    }
}
