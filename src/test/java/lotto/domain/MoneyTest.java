package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    @DisplayName("생성/천원단위로받음/생성완료")
    void 천원단위로_숫자가들어오면_생성() {
        // when then
        assertThat(new Money(1000)).isInstanceOf(Money.class);
    }

    @Test
    @DisplayName("생성실패/천원단위가 아니다./IllegalArgumentException")
    void 천원단위로_숫자가_안들어오면_에러() {
        // when then
        assertThatThrownBy(() -> new Money(1001)).isInstanceOf(IllegalArgumentException.class);
    }
}