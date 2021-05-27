package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoSellerTest {

    @DisplayName("로또를 구입할 금액과 자동 수동 갯수를 전달했을때 판매원의 돌려주는 로또응모지갑을 테스트")
    @ParameterizedTest
    @CsvSource(value = {"5000:0:5", "5000:3:2", "5000:5:0"}, delimiter = ':')
    public void lottoSellerTest(String inputMoney, int countOfManualLottoTicket, int countOfAutoLottoTicket) {
        PurchaseBudget purchaseBudget = getPurchaseBudget(inputMoney, countOfManualLottoTicket);


        List<LottoTicket> lottoTickets = makeLottoTickets(countOfManualLottoTicket);

        LottoSeller lottoSeller = new LottoSeller(new TestNumberGeneratorStrategy());
        LottoWallet lottoWallet = lottoSeller.sell(lottoTickets, purchaseBudget);

        assertThat(lottoWallet.getAutoTicketCount()).isEqualTo(countOfAutoLottoTicket);
        assertThat(lottoWallet.getManualTicketCount()).isEqualTo(countOfManualLottoTicket);
    }

    private PurchaseBudget getPurchaseBudget(String inputMoney, int countOfManualLottoTicket) {
        Money money = Money.create(inputMoney);
        return PurchaseBudget.create(money, countOfManualLottoTicket);
    }

    private List<LottoTicket> makeLottoTickets(int ticketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        List<String> lottoNumberText = Arrays.asList("1", "2", "3", "4", "5", "6");

        for (int i = 0; i < ticketCount; i++) {
            List<LottoNumber> lottoNumbers = makeLottoNumbers(lottoNumberText);
            lottoTickets.add(LottoTicket.create(lottoNumbers));
        }

        return lottoTickets;
    }

    private List<LottoNumber> makeLottoNumbers(List<String> lottoNumberText) {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        return lottoNumberGenerator.generator(lottoNumberText);
    }

}
