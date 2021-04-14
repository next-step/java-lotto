package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
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

    @DisplayName("로또 수동 테스트")
    @ParameterizedTest
    @CsvSource(value ={"1000,1,0", "2000,1,1", "20000,10,10, 100000,100,0"})
    void createdManualMoneyTest(int moneys, int manualCount, int autoCount){
        Money money = new Money(moneys, manualCount);
        assertThat(money.getTicketCount()).isEqualTo(autoCount);
    }

    @DisplayName("구매 금액 보다 큰 로또 수량 구매시 에러 체크")
    @ParameterizedTest
    @CsvSource(value ={"1000,3", "20000,30, 100000,200"})
    void failMoneyTest(int moneys, int manualCount){
        assertThatThrownBy(() ->
            new Money(moneys, manualCount)
        ).isInstanceOf(IllegalArgumentException.class);
    }


}
