package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

class NumberTest {
    @Test
    void 총합() {
        Number number = new Number(1);
        assertThat(number.sum(0, List.of(new Number(1)))).isEqualTo(1);
    }

    @Test
    void 로또번호_일치_개수() {
        Number number = new Number(1);
        assertThat(number.countMatch(List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)))).isEqualTo(1);
    }
}