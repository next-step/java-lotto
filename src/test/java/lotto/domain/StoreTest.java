package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StoreTest {

    @Test
    @DisplayName("입력받은 구매 금액을 로또 가격으로 나눈 금액 만큼 로또를 생성한다.")
    void generate_lottery() {
        // given
        Store store = new Store(14000);

        // when
        int lotteryCount = store.getLotteryCount();

        // then
        assertThat(lotteryCount).isEqualTo(14);
    }

    @Test
    @DisplayName("입력 금액이 로또 금액에 떨어지지 않으면 예외를 발생한다.")
    void when_DoesNotDividedByLotteryPrice_ThrowsException() {
        // given
        int price = 11111;

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Store(price));
    }
}