package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoWalletTest {

    @DisplayName("로또의 구입가능한 갯수 및 구입결과 확인 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:0:1", "1500:0:1", "2000:1:1", "10900:5:5"}, delimiter = ':')
    public void createLottoWallet(String inputMoney, int countOfManualLottoTicket, int countOfAutoLottoTicket) {
        Money money = Money.create(inputMoney);
        LottoWallet lottoWallet = LottoWallet.create(money, countOfManualLottoTicket);
        lottoWallet.buyingLotto(new TestNumberGeneratorStrategy(), manualNumbers(countOfManualLottoTicket));

        assertThat(lottoWallet.takeOutLottoTickets()).hasSize(countOfManualLottoTicket + countOfAutoLottoTicket);
    }

    @DisplayName("로또구입금액별 수동구매에 따른 자동구매 갯수 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1000:0:1", "2000:1:1", "5000:5:0", "12000:5:7"}, delimiter = ':')
    public void countManualAndAutoLottoSize(String inputMoney, int countOfManualLottoTicket, int countOfAutoLottoTicket) {
        Money money = Money.create(inputMoney);
        LottoWallet lottoWallet = LottoWallet.create(money, countOfManualLottoTicket);
        lottoWallet.buyingLotto(new TestNumberGeneratorStrategy(), manualNumbers(countOfManualLottoTicket));

        assertThat(lottoWallet.getManualTicketCount()).isEqualTo(countOfManualLottoTicket);
        assertThat(lottoWallet.getAutoTicketCount()).isEqualTo(countOfAutoLottoTicket);
    }

    public List<List<String>> manualNumbers(int countOfManualLottoTicket) {
        List<List<String>> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < countOfManualLottoTicket; i++) {
            List<String> manualNumber = Arrays.asList("1", "2", "3", "4", "5", "6");
            lottoNumbers.add(manualNumber);

        }
        return lottoNumbers;
    }

    @DisplayName("1000원 미만의 금액은 로또를 구입할수 없다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "500:0", "999:0"}, delimiter = ':')
    public void invalidAmountMoneyTest(String inputMoney, int countOfManualLottoTicket) {
        Money money = Money.create(inputMoney);

        assertThatThrownBy(() -> LottoWallet.create(money, countOfManualLottoTicket))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("총 구매갯수보다 수동의갯수가 더 많을수는없다")
    @ParameterizedTest
    @CsvSource(value = {"2000:3", "1000:2", "10000:11"}, delimiter = ':')
    public void invalidCountOfManualTicketTest(String inputMoney, int countOfManualLottoTicket) {
        Money money = Money.create(inputMoney);

        assertThatThrownBy(() -> LottoWallet.create(money, countOfManualLottoTicket))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
