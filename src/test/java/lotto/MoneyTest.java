package lotto;

import lotto.model.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @DisplayName("지불한 돈 출력")
    @Test
    void 돈_출력() {
        assertThat(new Money(5000).getMoney()).isEqualTo(5000);
    }

    @DisplayName("최소 로또 금액보다 지불한 돈이 적다.")
    @Test
    void 최소_금액_부족() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money(999)).withMessage("로또를 한장도 구매할 수 없습니다.");
    }

    @DisplayName("최소 로또 금액보다 지불한 돈이 적다.")
    @Test
    void 빈_돈_입력() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money(null)).withMessage("알맞은 금액을 입력해주세요.");
    }
}

