package lotto.domain;

import lotto.domain.item.LottoTicket;
import lotto.domain.item.LottoTickets;
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

    List<Integer> luckyNumber = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

    List<LottoTicket> ticketList = new ArrayList<>(Arrays.asList(
            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 10, 11, 12))),
//            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 11, 12, 13))),
//            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 2, 3, 20, 30, 45))),

            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 20, 21, 22, 23, 24))),
            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 20, 21, 22, 23, 24))),
            new LottoTicket(new ArrayList<Integer>(Arrays.asList(1, 20, 21, 22, 23, 24)))
    ));

    @DisplayName("생성자 테스트")
    @Test
    public void constructor() throws Exception {
        LottoGame lottoGame = new LottoGame(new Money(10000));
    }

    @DisplayName("입력금액에서 구매 가능한 로또만큼 구매 되는지 체크")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "5000:5"}, delimiter = ':')
    public void buyLotto(int myMoney, int expect) throws Exception {
        //given
        LottoGame lottoGame = new LottoGame(new Money(myMoney));

        //when
        LottoDto dto = lottoGame.play();

        //then
        assertThat(dto.getTickets().size()).isEqualTo(expect);
    }

    @DisplayName("수익률 개산")
    @Test
    public void erning() throws Exception {
        //given
        LottoTickets lottoTickets = new LottoTickets(ticketList);
        LottoGame lottoGame = new LottoGame(new Money(14000), lottoTickets);

        //when
        LottoDto earningRate = lottoGame.getEarningRate(luckyNumber);

        //then
        assertThat(earningRate.getEarningRate()).isEqualTo(0.35);
    }
}
