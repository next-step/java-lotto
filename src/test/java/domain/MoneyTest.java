package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("로또 구매 수량 체크")
    @ParameterizedTest
    @CsvSource(value ={"1000,1", "20000,20, 100000,100"})
    void buyLottoTest(int buyMoney, int ticketCount){
        Money money = new Money(buyMoney);
        assertThat(money.getTicketCount()).isEqualTo(ticketCount);
    }

    @DisplayName("Money 생성 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1000,2000,3000})
    void createdMoneyTest(int moneys){
        Money money = new Money(moneys);
        assertThat(money).isEqualTo(new Money(moneys));
    }
}
