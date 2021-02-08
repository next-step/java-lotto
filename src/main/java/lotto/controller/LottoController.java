package lotto.controller;

import lotto.domain.LotteryNumber;
import lotto.domain.LottoService;
import lotto.domain.LottoTicket;
import lotto.domain.Rank;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

import static lotto.utils.InputValidator.checkDuplicateNumberValidation;
import static lotto.utils.InputValidator.checkDuplicateBonusNumberValidation;

public class LottoController {
    private final LottoService lottoService = new LottoService();

    public void buyLottoProcess () {
        int price = InputView.inputPrice();
        int numberOfLotto = price / LottoTicket.PRICE;

        int numberOfManualLotto = InputView.inputNumberOfManualLottoTicket(numberOfLotto);
        OutputView.printAskWinningNumberMessage();
        lottoService.buyManualLottoTickets(numberOfManualLotto);

        int numberOfAutomaticLotto = numberOfLotto - numberOfManualLotto;
        lottoService.buyAutomaticLottoTickets(numberOfAutomaticLotto);
        OutputView.printNumberOfLotto(numberOfManualLotto, numberOfAutomaticLotto);
        List<LottoTicket> lottoTickets = lottoService.getLottoTickets();
        for (LottoTicket lottoTicket : lottoTickets) {
            OutputView.printLottoPickedNumber(lottoTicket);
        }
    }

    public void pickLotteryNumber () {
        List<Integer> winningNumbers = InputView.inputWinningNumbers();
        checkDuplicateNumberValidation(winningNumbers);
        int bonusNumber = InputView.inputBonusNumber();
        checkDuplicateBonusNumberValidation(winningNumbers, bonusNumber);

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