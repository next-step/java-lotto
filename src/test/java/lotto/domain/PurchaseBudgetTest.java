package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseBudgetTest {

    @DisplayName("1000원 미만의 금액은 로또를 구입할수 없다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "500:0", "999:0"}, delimiter = ':')
    public void invalidAmountMoneyTest(String inputMoney, int countOfManualLottoTicket) {
        Money money = Money.create(inputMoney);


        assertThatThrownBy(() -> PurchaseBudget.create(money, countOfManualLottoTicket))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총 구매갯수보다 수동의갯수가 더 많을수는없다")
    @ParameterizedTest
    @CsvSource(value = {"2000:3", "1000:2", "10000:11"}, delimiter = ':')
    public void invalidCountOfManualTicketTest(String inputMoney, int countOfManualLottoTicket) {
        Money money = Money.create(inputMoney);

        assertThatThrownBy(() -> PurchaseBudget.create(money, countOfManualLottoTicket))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력예산으로 구입할수 있는 로또의 갯수 확인")
    @ParameterizedTest
    @CsvSource(value = {"2900:1:1", "2000:1:1", "1000:1:0", "1000:0:1", "10000:5:5"}, delimiter = ':')
    public void purchaseBudgeTest(String inputMoney, int countOfManualLottoTicket, int countOfAutoLottoTicket) {
        Money money = Money.create(inputMoney);
        PurchaseBudget purchaseBudget = PurchaseBudget.create(money, countOfManualLottoTicket);

        assertThat(purchaseBudget.getAutoTicketCount()).isEqualTo(countOfAutoLottoTicket);
        assertThat(purchaseBudget.getManualTicketCount()).isEqualTo(countOfManualLottoTicket);
    }
}
