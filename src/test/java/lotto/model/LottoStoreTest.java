package lotto.model;

import lotto.model.generator.ManualLottoGenerator;
import lotto.model.generator.RandomLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.model.LottoTest.ofNumbers;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoStoreTest {

    private Money moneyToBuy;
    private List<String> numbersOfManual;

    @DisplayName("로또 한장을 자동으로 구매한다")
    @Test
    void buyLottoSuccess() {
        Wallet wallet = new Wallet(Lotto.PRICE);
        int countOfBuyLotto = (int) wallet.countAvailableByLotto();

        LottoTicket lottoTicket = LottoStore.buy(wallet, new RandomLottoGenerator(countOfBuyLotto));

        assertThat(lottoTicket.getLottos()).hasSize(countOfBuyLotto);
    }

    @DisplayName("로또 한장을 수동으로 구매한다")
    @Test
    void buyManualLotto() {
        Wallet wallet = new Wallet(Lotto.PRICE);
        numbersOfManual = Arrays.asList("1,2,3,4,5,6");

        LottoTicket lottoTicket = LottoStore.buy(wallet, new ManualLottoGenerator(numbersOfManual));

        assertThat(lottoTicket.getLottos()).hasSize(1);
        assertThat(lottoTicket.getLottos()).extracting(Lotto::getNumbers)
                .contains(ofNumbers(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("수동으로 1장, 자동으로 2장 구매한다")
    @Test
    void buyMultiLotto() {
        long countOfLotto = 2;
        Wallet wallet = new Wallet(Money.won(3000));
        List<String> numbersOfManual = Arrays.asList("1,2,3,4,5,6");

        LottoTicket lottoTicketOfManual = LottoStore.buy(wallet, new ManualLottoGenerator(numbersOfManual));
        LottoTicket lottoTicketOfAuto = LottoStore.buy(wallet, new RandomLottoGenerator(countOfLotto));
        LottoTicket lottoTicket = lottoTicketOfAuto.merge(lottoTicketOfManual);

        assertThat(lottoTicket.getLottos()).hasSize(3);
        assertThat(lottoTicket.getLottos()).extracting(Lotto::getNumbers)
                .contains(ofNumbers(1, 2, 3, 4, 5, 6));
    }
}
