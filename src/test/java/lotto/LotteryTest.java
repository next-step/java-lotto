package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LotteryTest {

    @Test
    @DisplayName("입력받은 구매 금액을 로또 가격으로 나눈 금액 만큼 로또를 생성한다.")
    void generate_lottery() {
        // given
        int inputMoney = 14000;

        // when
        Lottery lotto = new Lottery(inputMoney);

        // then
        int lotteryCount = lotto.getCount();
        assertThat(lotteryCount).isEqualTo(14);
    }

    @Test
    @DisplayName("입력 금액이 로또 금액에 떨어지지 않으면 예외를 발생한다.")
    void when_DoesNotDividedByLotteryPrice_ThrowsException() {
        // given
        int inputMoney = 11111;

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lottery(inputMoney));
    }

    @Test
    @DisplayName("입력 금액이 로또 금액보다 작으면 예외를 발생시킨다.")
    void when_InputIsLessThanLotteryPrice_ThrowsException() {
        // given
        int inputMoney = 0;

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lottery(inputMoney));
    }
}
