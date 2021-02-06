package lotto.controller;

import lotto.domain.LottoService;
import lotto.domain.LottoTicket;
import lotto.domain.LottoNumber;
import lotto.domain.LotteryNumber;
import lotto.domain.Rank;
import lotto.domain.Money;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoController {
    private final LottoService lottoService;
    private Map<Rank, Integer> lottoRankingStatus;

    public LottoController() {
        lottoService = new LottoService();
    }

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void buyLottoProcess() {
        Money price = new Money(InputView.inputPrice());
        int allCountOfLotto = price.getAmount() / LottoTicket.PRICE;
        int countOfLottoManual = InputView.inputManualPurchaseCount();
        int countOfLottoAuto = allCountOfLotto - countOfLottoManual;
        buyLottoProcessManual(countOfLottoManual);
        buyLottoProcessAuto(countOfLottoAuto);
        OutputView.printNumberOfLotto(countOfLottoManual, countOfLottoAuto, lottoService.getLottoTickets());
    }

    public void buyLottoProcessManual(int countOfLotto){
        Validator.checkCountOfLottoBuy(countOfLotto);
        lottoService.buyLottoTicketManual(
                InputView.inputManualPurchaseLottoNumber(countOfLotto).stream()
                        .map(LottoTicket::of)
                        .collect(Collectors.toList())
        );
    }

    public void buyLottoProcessAuto(int countOfLotto){
        Validator.checkCountOfLottoBuy(countOfLotto);
        lottoService.buyLottoTicketsAuto(countOfLotto);
    }

    public void pickLotteryNumber() {
        List<LottoNumber> winningNumbers = InputView.inputWinningNumbers().stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
        LottoNumber bonusNumber = new LottoNumber(InputView.inputBonusNumber());

        LotteryNumber lotteryNumber = new LotteryNumber(winningNumbers, bonusNumber);
        lottoService.recordLotteryNumber(lotteryNumber);
    }

    public void showLottoResult() {
        lottoRankingStatus = Rank.getInitRankingDict();
        int profit = lottoService.calculateResult(lottoRankingStatus);
        double interestRate = lottoService.getInterestRate(profit);
        OutputView.printLottoServiceResult(lottoRankingStatus, interestRate);
    }

    public Map<Rank, Integer> getLottoRankingStatus() {
        return lottoRankingStatus;
    }
}
