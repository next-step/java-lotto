package lotto.service;

import lotto.domain.Money;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.LottoTickets;
import lotto.domain.lotto.WinLottoTicket;
import lotto.view.StatisticsLottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    LottoNumbers winNumber = LottoNumbers.createLottoNumbersUseInteger(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

    @DisplayName("구매할 금액과 수동으로 사려는 로또의 수량 비교")
    @ParameterizedTest
    @CsvSource(value = {"3000:2", "1111:1", "2999:1"}, delimiter = ':')
    public void validateAvailableQuantity_success(int inputMoney, String count) throws Exception {
        //given
        LottoService lottoService = new LottoService();

        //when
        int result = lottoService.validateAvailableQuantity(count, new Money(inputMoney));

        //then
        assertThat(result).isEqualTo(Integer.parseInt(count));
    }


    @DisplayName("수익률 개산")
    @Test
    public void getEarningRate_success() throws Exception {
        //given
        LottoService service = new LottoService();
        final WinLottoTicket winLottoTicket = new WinLottoTicket(winNumber, new LottoNumber(45));
        final LottoTickets lottoToPassivity =
                LottoTickets.from(Arrays.asList(LottoNumbers.of(Arrays.asList(1, 2, 3, 10, 11, 12))));

        //when
        StatisticsLottoDto earningRate = service.getEarningRate(lottoToPassivity, winLottoTicket);

        //then
        assertThat(earningRate.getEarningRate()).isEqualTo(5);
    }
}
