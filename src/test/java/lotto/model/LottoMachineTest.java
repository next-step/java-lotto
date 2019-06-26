package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.LottoTest.ofNumbers;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    PurchaseRequest purchaseRequest;
    LottoMachine lottoMachine = new LottoMachine();

    @DisplayName("잔액 부족으로 로또 구매 실패")
    @Test
    void buyLottoFail() {
        purchaseRequest = PurchaseRequest.of(Money.won(500), null);
        LottoTicket lottoTicket = lottoMachine.buy(purchaseRequest);
        assertThat(lottoTicket.getLottos()).hasSize(0);
    }

    @DisplayName("로또 한장을 자동으로 구매한다")
    @Test
    void buyLottoSuccess() {
        purchaseRequest = PurchaseRequest.of(Money.won(1000), null);

        LottoTicket buyLottos = lottoMachine.buy(purchaseRequest);

        assertThat(buyLottos.getLottos()).hasSize(1);
    }

    @DisplayName("로또 한장을 수동으로 구매한다")
    @Test
    void buyManualLotto() {
        List<String> numbersOfLotto = Arrays.asList("1,2,3,4,5,6");
        purchaseRequest = PurchaseRequest.of(Money.won(1000), numbersOfLotto);

        LottoTicket buyLottos = lottoMachine.buy(purchaseRequest);

        assertThat(buyLottos.getLottos()).hasSize(1);
        assertThat(buyLottos.getLottos()).extracting(Lotto::getNumbers)
                .contains(ofNumbers(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("수동으로 1장, 자동으로 2장 구매한다")
    @Test
    void buyMultiLotto() {
        Money money = Money.won(3000);
        List<String> numbersOfLotto = Arrays.asList("1,2,3,4,5,6");
        PurchaseRequest purchaseRequest = PurchaseRequest.of(money, numbersOfLotto);

        LottoTicket lottoTicket = lottoMachine.buy(purchaseRequest);

        assertThat(lottoTicket.getLottos()).hasSize(3);
        assertThat(lottoTicket.getLottos()).extracting(Lotto::getNumbers)
                .contains(ofNumbers(1, 2, 3, 4, 5, 6));
    }
}