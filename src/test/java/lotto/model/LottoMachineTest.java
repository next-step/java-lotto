package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.LottoTest.ofNumbers;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    Money moneyToBuy;
    List<String> numbersOfManual;

    @DisplayName("잔액 부족으로 로또 구매 실패")
    @Test
    void buyLottoFail() {
        moneyToBuy = Money.won(500);
        numbersOfManual = null;
        LottoTicket lottoTicket = LottoMachine.buy(moneyToBuy, null);
        assertThat(lottoTicket.getLottos()).hasSize(0);
    }

    @DisplayName("로또 한장을 자동으로 구매한다")
    @Test
    void buyLottoSuccess() {
        moneyToBuy = Money.won(1000);
        numbersOfManual = null;

        LottoTicket lottoTicket = LottoMachine.buy(moneyToBuy, numbersOfManual);

        assertThat(lottoTicket.getLottos()).hasSize(1);
    }

    @DisplayName("로또 한장을 수동으로 구매한다")
    @Test
    void buyManualLotto() {
        moneyToBuy = Money.won(1000);
        numbersOfManual = Arrays.asList("1,2,3,4,5,6");

        LottoTicket lottoTicket = LottoMachine.buy(moneyToBuy, numbersOfManual);

        assertThat(lottoTicket.getLottos()).hasSize(1);
        assertThat(lottoTicket.getLottos()).extracting(Lotto::getNumbers)
                .contains(ofNumbers(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("수동으로 1장, 자동으로 2장 구매한다")
    @Test
    void buyMultiLotto() {
        Money moneyToBuy = Money.won(3000);
        List<String> numbersOfManual = Arrays.asList("1,2,3,4,5,6");

        LottoTicket lottoTicket = LottoMachine.buy(moneyToBuy, numbersOfManual);

        assertThat(lottoTicket.getLottos()).hasSize(3);
        assertThat(lottoTicket.getLottos()).extracting(Lotto::getNumbers)
                .contains(ofNumbers(1, 2, 3, 4, 5, 6));
    }
}
