package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGameTest {

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
        int purchaseAmount = 3500;
        LottoGame lottoGame = LottoGame.of(purchaseAmount);
        assertThat(lottoGame.getCount()).isEqualTo(3);
    }
}
