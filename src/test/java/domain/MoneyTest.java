package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    public void 금액이_1000원_미만으로_들어오면_예외를_던진다() {
        //given
        int input = 999;
        int manualCount = 1;
        //when
        assertThatThrownBy(() -> {
            Money money = new Money(input, 1);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
