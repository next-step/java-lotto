package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @Test
    void create() {
        assertThat(new Money(14000).value()).isEqualTo(14000);
    }

    @Test
    void 음수가_될_수_없음() {
        assertThatThrownBy(() -> {
            new Money(-14000);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수 값이 들어올 수 없습니다.");
    }

    @Test
    void 로또_살_수_있는_장수() {
        assertThat(new Money(14000).getBuyableCount()).isEqualTo(14);
    }

    @Test
    void 수익률_계산() {
        assertThat(new Money(14000).getYield(new Money(5000))).isLessThan(1);
    }
}
