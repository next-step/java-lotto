package lotto.controller;

import lotto.domain.LotteryNumber;
import lotto.domain.LottoService;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {
    private final LottoService lottoService = new LottoService();
    
    public void buyLottoProcess () {
        int price = InputView.inputPrice();
        int numberOfLotto = price / LottoTicket.PRICE;

        lottoService.buyLottoTickets(numberOfLotto);
        OutputView.printNumberOfLotto(numberOfLotto);
        List<LottoTicket> lottoTickets = lottoService.getLottoTickets();
        for (LottoTicket lottoTicket : lottoTickets) {
            OutputView.printLottoPickedNumber(lottoTicket);
        }
    }

    public void pickLotteryNumber () {
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        int bonusNumber = InputView.inputBonusNumber();

        LotteryNumber lotteryNumber = new LotteryNumber(winningNumbers, bonusNumber);
        lottoService.recordLotteryNumber(lotteryNumber);
    }

    public void showLottoResult () {
        lottoService.calculatePrize();
        Map<Rank, Integer> lottoRankingStatus = lottoService.getLottoRankingStatus();
        double interestRate = lottoService.getInterestRate();
        OutputView.printLottoServiceResult(lottoRankingStatus, interestRate);
    }
}
