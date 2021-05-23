package lotto.shop;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.error.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MoneyTest {
    @Test
    @DisplayName("돈 생성")
    void create() {
        //given
        Money money = new Money(14000);
        //when
        int amount = money.amount();
        //then
        assertThat(amount).isEqualTo(14000);
    }

    @Test
    @DisplayName("돈이 음수가 되는 경우")
    void method() {
        //given
        //when
        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    Money money = new Money(-10);
                }).withMessageContaining(ErrorMessage.MONEY_CANNOT_BE_NEGATIVE);
    }
}
