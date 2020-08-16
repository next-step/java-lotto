package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {
    private static final int LOTTO_PRICE = 1_000;

    @DisplayName("1000원 이하 금액 예외처리 테스트")
    @ParameterizedTest
    @ValueSource(ints = {-10, 10, 500, 900})
    void lessThanLottoPriceTest(int price) {
        assertThatIllegalArgumentException().isThrownBy(() -> Money.of(price));
    }

    @DisplayName("입력한 금액에 따른 로또 갯수 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 13500, 30000})
    void divideMoneyToLottoPriceTest(int price) {
        assertThat(Money.of(price).getLottoCount()).isEqualTo(price / LOTTO_PRICE);
    }
}