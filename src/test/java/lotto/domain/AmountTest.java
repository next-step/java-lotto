package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AmountTest {
    @Test
    @DisplayName("객체 생성 테스트")
    void create() {
        final Amount amount = new Amount(10000);

        assertThat(amount)
                .isEqualTo(new Amount(10000));
    }

    @Test
    @DisplayName("금액이 음수일 경우 IllegalArgumentException 을 리턴한다.")
    void minusAmount() {
        assertThatThrownBy(() -> new Amount(-10000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("단위 금액이 주어질때 몇 개로 나눌 수 있는지 확인한다.")
    void calculateUnitAmount() {
        final Amount amount = new Amount(10001);

        assertThat(amount.calculateUnitCount(1000))
                .isEqualTo(10);
    }
}
