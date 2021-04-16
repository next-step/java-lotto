package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class MoneyTest {

    @Test
    @DisplayName("생성자 테스트")
    void create() {
        assertThat(Money.of(14000)).isEqualTo(Money.of(14000));
    }

    @Test
    @DisplayName("생성자 예외 테스트")
    void validate() {
        assertThatThrownBy(() -> Money.of(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("최소 금액은 1000원 입니다.");
    }

    @Test
    @DisplayName("정상 구매 테스트")
    void purchase() {
        assertAll(
                () -> assertThat(Money.of(1000).purchase()).isEqualTo(1),
                () -> assertThat(Money.of(14000).purchase()).isEqualTo(14)
        );
    }

    @Test
    @DisplayName("비정상 구매 예외 테스트")
    void validate_purchase() {
        assertThatThrownBy(() -> Money.of(900).purchase())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("최소 금액은 1000원 입니다.");
    }
}
