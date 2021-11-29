package lotto.domain;

import lotto.exception.EmptySourceException;
import lotto.exception.InvalidUnitException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PriceTest {

    @DisplayName("금액생성에 공백, null이 입력될 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    void validateEmptyAndNull(String price) {
        assertThatThrownBy(() -> Price.of(price)).isInstanceOf(EmptySourceException.class);
    }


    @DisplayName("100원 단위 입력시 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {
            "14100", "14300", "23100"
    })
    void validateMoneyUnit(String input) {
        assertThatThrownBy(() -> Price.of(input)).isInstanceOf(InvalidUnitException.class);
    }

    @DisplayName("1000단위에 맞추어 price가 생성된다.")
    @Test
    void createPrice() {
        // given
        String money = "14000";

        // when
        Price price = Price.of(money);

        // then
        assertThat(price.getNumberOfTickets()).isEqualTo(14);
    }
}