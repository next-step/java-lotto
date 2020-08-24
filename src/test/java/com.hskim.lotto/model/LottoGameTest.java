package com.hskim.lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        // given
        LottoTickets lottoTickets = LottoMachine.automaticIssuance(
                new PurchasePrice(10000), new FixedLottoNumberMaker()
        );
        LottoWinningTicket winningTicket = new LottoWinningTicket(Arrays.asList(1, 8, 9, 10, 17, 25), 5);
        LottoGame lottoGame = new LottoGame(lottoTickets, winningTicket);

        // when & then
        assertThat(lottoGame).isEqualTo(new LottoGame(lottoTickets, winningTicket));
    }

    @DisplayName("drawLotteryTicket() 테스트 - 로또 번호 추첨 동작 검증")
    @Test
    void drawLotteryTicket() {
        // given
        LottoTickets lottoTickets = makeLottoTickets();
        LottoWinningTicket winningTicket = new LottoWinningTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        LottoGame lottoGame = new LottoGame(lottoTickets, winningTicket);
        WinnerStatistics winnerStatistics = new WinnerStatistics();
        winnerStatistics.putData(Arrays.asList(LottoWinTable.FIRST_PLACE,
                LottoWinTable.SECOND_PLACE, LottoWinTable.THIRD_PLACE));
        BigDecimal income = LottoWinTable.FIRST_PLACE.getPrizeAmount().add(LottoWinTable.SECOND_PLACE.getPrizeAmount())
                .add(LottoWinTable.THIRD_PLACE.getPrizeAmount());

        EarningRate earningRate = new EarningRate(income, BigDecimal.valueOf(lottoTickets.getTotalTicketPrice()));
        LottoGameResult expected = new LottoGameResult(winnerStatistics, earningRate);

        // when
        LottoGameResult result = lottoGame.drawLotteryTicket();

        // then
        assertThat(result).isEqualTo(expected);
    }

    /*
        당첨번호 1,2,3,4,5,6 + 7에 대해 1,2,3등 복권
     */
    private LottoTickets makeLottoTickets() {
        List<LottoTicket> lottoTicketList = new LinkedList<>();
        lottoTicketList.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoTicketList.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7)));
        lottoTicketList.add(new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 9)));

        return new LottoTickets(lottoTicketList);
    }
}
