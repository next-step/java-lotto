package lottery.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ProfitTest {

    @Test
    @DisplayName("수익률을 계산한다.")
    void profit_test() {
        //given
        Profit profit = new Profit(new Money(2000), 1_500_000);

        //then
        assertThat(profit).isEqualTo(new Profit(750.0));
    }

    @ParameterizedTest
    @ValueSource(ints = {-332, -10, 0})
    @DisplayName("당첨금이 1보다 작은 경우 예외처리한다.")
    void validateJackpot_test(int jackpot) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Profit(new Money(3000), jackpot));
    }
}
