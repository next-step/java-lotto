package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class MoneyTest {

    @DisplayName("1000원 이상 생성시 에러없이 생성")
    @ParameterizedTest
    @ValueSource(ints = {1000, 1200, 2000})
        //given
    void create(final int money) {
        //when
        int result = new Money(money).getMoney();

        //then
        assertThat(result).isEqualTo(money);
    }

    @DisplayName("1000원 미만 금액을 입력시 exception")
    @ParameterizedTest
    @ValueSource(ints = {100, 900, 999})
        //given
    void invalid_money_exception(final int money) {
        //when, then
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(money));
    }

    @DisplayName("14000원이면 14개의 lottoCount를 리턴하는지")
    @Test
    void how_many_lotto() {
        //given
        int inputMoney = 14000;
        int expected = 14;

        //when
        Money money = new Money(inputMoney);
        int result = money.getLottoCount();

        //then
        assertThat(result).isEqualTo(expected);
    }
}
