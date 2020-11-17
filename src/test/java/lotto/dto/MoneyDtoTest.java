package lotto.dto;

import lotto.domain.Money;
import lotto.exception.BadMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class MoneyDtoTest {


    @ParameterizedTest
    @DisplayName("money 가 0보다 작으면, BadMoneyException 이 발생한다.")
    @ValueSource(ints = {-379, -1})
    public void of_int(int money) {
        assertThatExceptionOfType(BadMoneyException.class)
                .isThrownBy(() -> MoneyDto.of(money));
    }

    @ParameterizedTest
    @DisplayName("엔티티로 Money 객체를 반환해야 한다.")
    @ValueSource(ints = {0, 100, 33333})
    void toEntity(int money) {
        assertThat(MoneyDto.of(money).toEntity())
                .isEqualTo(new Money(money));
    }
}
