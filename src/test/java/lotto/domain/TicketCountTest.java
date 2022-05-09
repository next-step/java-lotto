package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TicketCountTest {

    @Test
    void TicketCount는_음수로_생성할시_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new TicketCount(TicketCount.ZERO - 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void TicketCount는_숫자가_아닌_문자열로_생성_할_경우_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            new TicketCount("문자");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isZero는_값이_0인_경우_true을_반환한다() {
        assertAll(
                () -> assertTrue(new TicketCount(0).isZero()),
                () -> assertFalse(new TicketCount(1).isZero())
        );
    }
}
