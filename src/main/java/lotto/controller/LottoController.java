package lotto.controller;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public static void main(String[] args) {
        int totalPriceToBuyLotto = InputView.totalPrice();
        int numberOfLotto = totalPriceToBuyLotto / 1000;
        OutputView.numberOfLotto(numberOfLotto);
        LottoTicket lottoTicket = new LottoTicket(numberOfLotto);
        OutputView.ticketNumbers(lottoTicket);

        LottoNumbers winningNumbers = new LottoNumbers(InputView.winningNumber());
        winningNumbers.validate();
        LottoResult lottoResult = new LottoResult(lottoTicket, winningNumbers);

        OutputView.resultStartingPoint();
        OutputView.winningLottoCounts(lottoResult);
        OutputView.rateOfReturn(lottoResult.calculateRateOfReturn(totalPriceToBuyLotto));
    }
}
