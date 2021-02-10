package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyTest {
    @DisplayName("로또 복권 이하(1000원)의 가격을 등록했을 때, Illegal 에러를 발생시키는 테스트")
    @Test
    void validateIllegalMoneyTest() {
        //given & when & then
        assertThrows(IllegalArgumentException.class,
                () -> new Money(999));
    }

    @DisplayName("3000원을 지불했을 때, amount가 3000원이 나오는 지 확인하는 테스트")
    @Test
    void getAmountTest() {
        //given
        final Money money = new Money(3_000);

        //when
        int moneyAmount = money.getAmount();

        //then
        assertThat(moneyAmount).isEqualTo(3_000);
    }
}
