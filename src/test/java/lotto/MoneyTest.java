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
        assertThatIllegalArgumentException().isThrownBy(() -> Money.won(-1));
    }

    @Test
    @DisplayName("돈 더하기 테스트")
    public void plusMoneyTest() {
        assertThat(Money.won(1000).plus(Money.won(1000))).isEqualTo(Money.won(2000));
    }

    @Test
    @DisplayName("돈 빼기 테스트")
    public void minusTest() {
        assertThat(Money.won(1000).minus(Money.won(500))).isEqualTo(Money.won(500));
    }

    @Test
    @DisplayName("더 많은 양의 돈으로 뺄 수 없다")
    public void minusExceptionTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> Money.won(100).minus(Money.won(1000)));
    }

    @Test
    @DisplayName("돈 n 배 테스트")
    public void timesMoneyTest() {
        assertThat(Money.won(1000).times(2)).isEqualTo(Money.won(2000));
    }

    @Test
    @DisplayName("돈 n 으로 나누기 테스트")
    public void divideMoneyTest() {
        assertThat(Money.won(1000).divide(Money.won(300), 1, RoundingMode.UP)).isEqualTo(BigDecimal.valueOf(3.4));
    }

    @Test
    @DisplayName("정수 값을 얻기 위해 돈을 나누면 소수점은 무시된다.")
    public void divideToIntTest() {
        assertThat(Money.won(3000).divideToInt(Money.won(2500))).isEqualTo(1);
        assertThat(Money.won(3000).divideToInt(Money.won(3500))).isEqualTo(0);
    }

    @Test
    @DisplayName("돈의 양 비교 테스트")
    public void moreWorthTest() {
        assertThat(Money.won(3000).biggerThan(Money.won(2000))).isTrue();
        assertThat(Money.won(3000).biggerThan(Money.won(3000))).isFalse();
        assertThat(Money.won(3000).biggerThan(Money.won(4000))).isFalse();
    }

}
