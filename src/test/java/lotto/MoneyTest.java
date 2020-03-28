package lotto;

import lotto.model.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class MoneyTest {
    @DisplayName("Money 객체는 인자로 받는 금액(long type)에 따라 구별된다.")
    @ParameterizedTest
    @ValueSource(longs = {1000, 12000})
    void createMoneyTest(long input) {
        assertThat(new Money(input)).isEqualTo(new Money(input));
    }

    @DisplayName("음수를 입력받으면 객체는 예외를 반환한다.")
    @ParameterizedTest
    @ValueSource(longs = {-1, -10, -10000})
    void validateNegativeTest(long input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Money(input);
        });
    }

    @DisplayName("몇 개의 로또를 살 수 있는지 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "1100:1", "15000:15", "14900:14"}, delimiter = ':')
    void findLottoCountToBuyTest(Long input, long expected) {
        //given
        Money money = new Money(input);

        //when
        long lottoCountToBuy = money.findLottoCountToBuy();

        //then
        assertThat(lottoCountToBuy).isEqualTo(expected);
    }
}