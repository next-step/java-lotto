package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @DisplayName("생성자 테스트")
    @Test
    public void construct() throws Exception {
        //given
        Money money1 = new Money(1000);
        Money money2 = new Money(1000);

        //then
        assertThat(money1.equals(money2)).isTrue();
    }

    @DisplayName("양의 정수인지 체크")
    @ParameterizedTest
    @ValueSource(ints = {-1, -2, -10, -100})
    public void validatePositive(int money) throws Exception {
        //given
        assertThatThrownBy(
                () -> new Money(money)
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("금액은 양의 정수만 입력 가능 합니다.");
    }

    @DisplayName("금액 덧셈 기능")
    @ParameterizedTest
    @CsvSource(value = {"100:100:200", "1000:3000:4000"}, delimiter = ':')
    public void plus(int int1, int int2, int expect) throws Exception {
        //given
        Money money1 = new Money(int1);
        Money money2 = new Money(int2);

        //when
        money1 = money1.plus(money2);

        //then
        assertThat(money1.getMoney()).isEqualTo(expect);
    }

    @DisplayName("입력 급액으로 몇개가 구매 가능한지 테스트")
    @ParameterizedTest
    @CsvSource(value = {"10000:1000:10", "5000:1000:5", "5000:500:10"}, delimiter = ':')
    public void getHowManyBuyItem(int myMoney, int itemPrice, int count) throws Exception {
        //given
        Money money = new Money(myMoney);
        Money price = new Money(itemPrice);

        //when
        int howManyBuyItem = money.getHowManyBuyItem(price);

        //then
        assertThat(howManyBuyItem).isEqualTo(count);
    }

}
