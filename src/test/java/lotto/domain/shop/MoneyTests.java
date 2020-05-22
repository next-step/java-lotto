package lotto.domain.shop;

import lotto.domain.shop.exceptions.OnlyTenThousandsException;
import lotto.domain.shop.exceptions.OutOfBoundMoneyCreationException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTests {
    @DisplayName("long 값을 입력 받아서 객체를 생성 할 수 있다.")
    @Test
    void createTest() {
        assertThat(new Money(1000L)).isNotNull();
    }

    @DisplayName("0원 이하나 10만 초과의 값으로는 생성할 수 없다.")
    @ParameterizedTest
    @ValueSource(longs = {-1L, 0L, 100001L})
    void minMaxTest(long invalidValue) {
        assertThatThrownBy(() -> new Money(invalidValue)).isInstanceOf(OutOfBoundMoneyCreationException.class);
    }

    @DisplayName("1000원 단위로만 생성될 수 있다.")
    @ParameterizedTest
    @ValueSource(longs = {1L, 333L, 10023L})
    void onlyThousandsTest(long invalidValue) {
        assertThatThrownBy(() -> new Money(invalidValue)).isInstanceOf(OnlyTenThousandsException.class);
    }
}
