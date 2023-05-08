package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    public void 금액이_1000원_미만으로_들어오면_예외처리한다() {
        //given
        int input = 999;

        //when
        assertThatThrownBy(() -> {
            Money money = new Money(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
