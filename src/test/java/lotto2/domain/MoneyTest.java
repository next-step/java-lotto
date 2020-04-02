package lotto2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class MoneyTest {

    @DisplayName("Money 클래스를 생성할 수 있다.")
    @Test
    void canCreate() {
        new Money(1000);
    }

    @DisplayName("구입한 로또의 갯수를 구할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {1000})
    void testMoneyPerLottoCount(final int amount) {
        Money money = new Money(amount);
        assertThat(money.getLottoCount()).isEqualTo(1);
    }

    @DisplayName("금액은 1000원 이상 입력되어한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 500})
    void testMoneyOverThousand(final int amount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Money(amount));
    }

}
