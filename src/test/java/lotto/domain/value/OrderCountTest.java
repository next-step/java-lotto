package lotto.domain.value;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderCountTest {

    @Test
    @DisplayName("생성 테스트")
    void createTest() {
        OrderCount orderCount = OrderCount.from(3);

        assertThat(orderCount.getLottoCount()).isEqualTo(3);
    }

    @Test
    @DisplayName("예외 검증")
    void exceptionTest() {

        assertThatThrownBy(() ->
                OrderCount.from(0)).isInstanceOf(IllegalArgumentException.class);
    }
}
