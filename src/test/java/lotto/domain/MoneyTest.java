package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import calculator.StringCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    private Money moneyManager;

    @BeforeEach
    void setUp() {
        moneyManager = new Money();
    }

    @DisplayName(value = "구매 금액을 입력하면 구매 갯수를 반환한다")
    @ParameterizedTest
    @ValueSource(ints = {14000})
    void getLottoTicketCount(final int money) {
        assertThat(moneyManager.getLottoTicketCount(money)).isEqualTo(14);
    }

}