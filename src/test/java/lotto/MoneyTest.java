package lotto;

import lotto.domain.Money;
import lotto.exception.CustomIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @DisplayName("금액을 로또가격으로 나눈 값이 정수가 아닐 경우, Exception 발생")
    @Test
    void throw_exception_when_mod_is_not_zero() {
        //Given + When + Then
        assertThatThrownBy(() -> new Money(1800))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }

    @DisplayName("유효하지 않은 값을 금액으로 입력한 경우, Exception을 발생시킨다")
    @ParameterizedTest(name = "{displayName} ==> input : {0}")
    @ValueSource(strings = {"0", "100001", "-1"})
    void throw_exception_when_invalid_purchase_amount(int input) {
        //Given + When + Then
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(CustomIllegalArgumentException.class);
    }

}
