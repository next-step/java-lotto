package lotto;

import lotto.domain.*;
import lotto.domain.ticket.LottoTicket;
import lotto.domain.ticket.LottoTicketAutoGenerator;
import lotto.domain.ticket.LottoTicketManualGenerator;
import lotto.dto.LottoRequestDto;
import lotto.dto.WinningLottoDto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class Main {

    private static LottoShop lottoShop = new LottoShop(new LottoTicketManualGenerator(), new LottoTicketAutoGenerator());
    private static LottoGame lottoGame = new LottoGame();

    public static void main(String[] args) {

        LottoRequestDto lottoInputDto = InputView.inputAmountAndLottoNumber();

        List<LottoTicket> lottoTickets = lottoShop.buy(lottoInputDto.getManualLottoNumbers(), lottoInputDto.getAutoAmount());
        ResultView.printBuyingTickets(lottoTickets);

        WinningLottoDto winningLottoDto = InputView.inputWinningLottoNumber();

        int round = 1;
        lottoGame.add(round, winningLottoDto.getWinningLottoNumber(), winningLottoDto.getBonusNumber());

        LottoAnalyzer lottoAnalyzer = new LottoAnalyzer(lottoGame, lottoTickets);
        List<LottoRank> lottoRanks = lottoAnalyzer.gradeTicketRank(round);

        ResultView.printLottoRanks(LottoRank.convertLottoRankWithCount(lottoRanks));
        ResultView.printRevenueRate(lottoAnalyzer.calculateRevenueRate(round));

    }
}
