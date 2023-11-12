package lotto;

import lotto.domain.InputValidator;
import lotto.exception.InsufficientPriceException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 999})
    @DisplayName("1000원 미만일 경우 로또를 구매할 수 없다.")
    void fail_moving_cars(int price){
        InputValidator inputValidator = new InputValidator();

        Assertions.assertThatThrownBy(() -> inputValidator.validatePurchasePrice(price))
                .isInstanceOf(InsufficientPriceException.class)
                .hasMessage("로또 최소 금액 단위는 1000원 입니다.");
    }
}
