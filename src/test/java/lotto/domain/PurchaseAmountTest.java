package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PurchaseAmountTest {

    @DisplayName("구매금액(cash)에 따라서 몇 번의 구매인지 체크")
    @ParameterizedTest
    @CsvSource(value = {"1000:1","2000:2","3000:3","4000:4"}, delimiter = ':')
    void purchaseAmount_happyCase(int cash, int expected) {
        PurchaseAmount purchaseAmount = new PurchaseAmount(cash);
        assertThat(purchaseAmount.purchases()).isEqualTo(expected);
    }

    @DisplayName("구매금액(cash)의 유효성 검사 - 1000원 이하일때, 1000원의 배수가 아닐 때")
    @ParameterizedTest
    @ValueSource(ints = {0,1500,2500,999})
    @NullAndEmptySource
    void createLottoList_blueCase(int cash) {
        assertThatThrownBy(() -> new PurchaseAmount(cash))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
