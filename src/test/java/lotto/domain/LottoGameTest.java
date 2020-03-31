package lotto.domain;

import lotto.domain.item.*;
import lotto.service.LottoGame;
import lotto.view.LottoDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    LottoNumbers luckyNumber = LottoNumbers.createLottoNumbersUseInteger(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

    List<LottoTicket> ticketList = new ArrayList<>(Arrays.asList(
            new LottoTicket(LottoNumbers.createLottoNumbersUseInteger(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 10, 11, 12)))),
            new LottoTicket(LottoNumbers.createLottoNumbersUseInteger(new ArrayList<Integer>(Arrays.asList(1, 20, 21, 22, 23, 24)))),
            new LottoTicket(LottoNumbers.createLottoNumbersUseInteger(new ArrayList<Integer>(Arrays.asList(1, 20, 21, 22, 23, 24)))),
            new LottoTicket(LottoNumbers.createLottoNumbersUseInteger(new ArrayList<Integer>(Arrays.asList(1, 20, 21, 22, 23, 24))))
    ));

    @DisplayName("생성자 테스트")
    @Test
    public void constructor_success() throws Exception {
        LottoGame lottoGame = new LottoGame(new Money(10000));
    }

    @DisplayName("입력금액에서 구매 가능한 로또만큼 구매 되는지 체크")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "5000:5"}, delimiter = ':')
    public void play_success_countBuyLotto(int myMoney, int expect) throws Exception {
        //given
        LottoGame lottoGame = new LottoGame(new Money(myMoney));

        //when
        LottoDto dto = lottoGame.play();

        //then
        assertThat(dto.getTickets().size()).isEqualTo(expect);
    }

    @DisplayName("수익률 개산")
    @Test
    public void getEarningRate_success() throws Exception {
        //given
        final Money money = new Money(4000);
        LottoGame lottoGame = new LottoGame(money, new LottoTickets(ticketList));
        WinLottoTicket winLottoTicket = new WinLottoTicket(luckyNumber, new LottoNumber(45));

        //when
        LottoDto earningRate = lottoGame.getEarningRate(winLottoTicket);

        //then
        assertThat(earningRate.getEarningRate()).isEqualTo(1.25);
    }
}
