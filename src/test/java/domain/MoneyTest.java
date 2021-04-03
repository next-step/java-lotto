package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("로또 구매 수량 체크")
    @ParameterizedTest
    @CsvSource(value ={"1_000:1", "20_000:20, 100_000:100"}, delimiter = ':')
    void test(int buyMoney, int ticketCount){
        Money money = new Money(buyMoney);
        assertThat(money.getTicketCount()).isEqualTo(ticketCount);
    }
}
