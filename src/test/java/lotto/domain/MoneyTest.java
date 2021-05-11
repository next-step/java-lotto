package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

class MoneyTest {

    @Test
    @DisplayName("Money 생성자 테스트")
    void create() {
        assertAll(
                () -> assertThat(Money.of(14000, 0)).isNotNull(),
                () -> assertThat(Money.of(14000, 1)).isNotNull(),
                () -> assertThat(Money.of(14000, 14)).isNotNull()
        );
    }

    @Test
    @DisplayName("자동 로또 구매 생성자 예외 테스트")
    void validate_autoPayment() {
        assertThatThrownBy(() -> Money.of(900, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("최소 금액은 1000원 입니다.");
    }

    @Test
    @DisplayName("수동 로또 생성자 예외 테스트")
    void validate_manualPayment() {
        assertThatThrownBy(() -> Money.of(1000, 2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("지불 금액 이상으로 수동 로또를 구매할 수 없습니다.");
    }

    @Test
    @DisplayName("자동 로또 정상 구매 테스트")
    void purchase() {
        assertAll(
                () -> assertThat(Money.of(1000, 0).purchaseAuto()).isEqualTo(1),
                () -> assertThat(Money.of(14000, 1).purchaseAuto()).isEqualTo(13),
                () -> assertThat(Money.of(14000, 14).purchaseAuto()).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("비정상 구매 예외 테스트 - 최소 금액")
    void validate_minimum_purchase() {
        assertThatThrownBy(() -> Money.of(900, 0).purchaseAuto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("최소 금액은 1000원 입니다.");
    }

    @Test
    @DisplayName("비정상 구매 예외 테스트 - 단위 금액")
    void validate_input_purchase() {
        assertThatThrownBy(() -> Money.of(1500, 0).purchaseAuto())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("금액은 1000원 단위 입니다.");
    }
}
