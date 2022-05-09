package Lotto.domain;

import Lotto.exception.TooSmallMoneyException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MoneyTest {

    @ParameterizedTest
    @ValueSource(ints = {1,100,500,999})
    @DisplayName("구매 금액이 1000원 미만이면 예외를 던진다.")
    public void validateTest(int money) {
        Assertions.assertThatExceptionOfType(TooSmallMoneyException.class).isThrownBy(
                () -> new Money(money).getMoney()
        );

    }

    @ParameterizedTest
    @CsvSource(value = {"10000:10", "25000:25", "25321:25"}, delimiter = ':')
    @DisplayName("구매 금액에 1000을 나누면 구매한 로또 장수가 나온다")
    public void lottoNumTest(int money, int lottoNum) {
        Assertions.assertThat(new Money(money).changeMoneyToLottoNum()).isEqualTo(lottoNum);
    }
}
