package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("금액이 1000원 아래이면 로또를 구입할 수가 없어 Exception 발생")
    @ParameterizedTest
    @ValueSource(longs = {0, 10, 999})
    void validateMoney(long value) {
        assertThatThrownBy(() -> new Money(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또를 살 수가 없습니다.");
    }

    @DisplayName("로또 티켓 갯수를 구한다. 1000원당 로또 티켓 한 장")
    @ParameterizedTest
    @CsvSource(value = {"13000:13", "20000000000:20000000"}, delimiter = ':')
    void computeLottoTickets(long value, int expected) {
        Money money = new Money(value);
        assertThat(money.computeLottoTickets()).isEqualTo(expected);
    }

    @DisplayName("받게 될 총 당첨 금액으로 수익률을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"14000:5000:0.35", "5000:5000:1.0"}, delimiter = ':')
    void calculateYield(long value, long sum, double expected) {
        Money money = new Money(value);
        assertThat(money.calculateYield(sum)).isEqualTo(expected);
    }
}
