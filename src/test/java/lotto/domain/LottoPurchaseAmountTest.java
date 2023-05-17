package lotto.domain;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class LottoPurchaseAmountTest {

    @DisplayName("금액유효테스트")
    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @ValueSource(ints = {100, 1001, 3200, 10})
    void 금액유효테스트(int amount) {
        assertThatThrownBy(() -> {
            LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(amount);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("구매금액은 1000원 이상 및 1000원 단위로 입력해야 합니다.");
    }

    @DisplayName("구매티켓확인")
    @ParameterizedTest(name = "{displayName} [{index}] {arguments}")
    @CsvSource(value = {"1000,1", "5000,5", "100000,100", "320000,320"})
    void 구매티켓확인(int amount, int count) {
        LottoPurchaseAmount lottoPurchaseAmount = new LottoPurchaseAmount(amount);

        Assertions.assertThat(lottoPurchaseAmount.getTicketCount()).isEqualTo(count);
    }
}