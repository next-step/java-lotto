package lotto.domain;

import lotto.vo.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {

    @DisplayName("숫자 이외의 값이 오면 IllegalArgumentException")
    @ParameterizedTest
    @ValueSource(strings = {"a", "한", "-", "/"})
    void notNumberTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Money.create(input));
    }

    @DisplayName("null or empty 값이 오면 IllegalArgumentException")
    @ParameterizedTest
    @NullAndEmptySource
    void notEmptyTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Money.create(input));
    }

    @DisplayName("로또를 살 수 있는 개수를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"5000:1000:5", "10000:1000:10"}, delimiter = ':')
    void NumberToBuyTest(String input, int priceMoney, int expect) {
        Money myMoney = Money.create(input);
        Money price = Money.create(priceMoney);

        assertThat(myMoney.getNumberToBuy(price)).isEqualTo(expect);
    }
}
