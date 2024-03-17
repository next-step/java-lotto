package model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoAmountTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1000, -2000, -100000})
    @DisplayName("로또 구매 금액이 양수가 아닌 경우 익셉션 발생시킨다")
    void lottoAmountTest(final int given) {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoAmount(given));
    }

    @ParameterizedTest
    @ValueSource(ints = {1300, 2700, 150000, 210000})
    @DisplayName("로또 구매 단위가 1000원 단위가 아닌 경우 익셉션 발생시킨다")
    void lottoAmountTest2() {
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoAmount(1300))
                .withMessage("로또 구매를 위한 금액은 1000단위여야 합니다.");
    }
}
