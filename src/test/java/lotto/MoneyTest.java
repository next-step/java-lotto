package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {

    @Test
    @DisplayName("음수는 돈이 될 수 없다.")
    public void minusMoneyTest() {
        assertThatIllegalArgumentException() .isThrownBy(() -> Money.won(-1));
    }

    @Test
    @DisplayName("돈 더하기 테스트")
    public void plusMoneyTest() {
        assertThat( Money.won(1000).plus(Money.won(1000))).isEqualTo(Money.won(2000));
    }

    @Test
    @DisplayName("돈 n 배 테스트")
    public void timesMoneyTest() {
        assertThat(Money.won(1000).times(2)).isEqualTo(Money.won(2000));
    }

    @Test
    @DisplayName("돈 n 으로 나누기 테스트")
    public void divideMoneyTest() {
        assertThat(Money.won(1000).divide(BigDecimal.valueOf(100))).isEqualTo(BigDecimal.valueOf(10));
        assertThat(Money.won(1000).divide(Money.won(300), 1, RoundingMode.UP)).isEqualTo(BigDecimal.valueOf(3.4));
    }

}
