package lotto;

import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.lotto.LottoGame;
import lotto.domain.lotto.LottoSeller;
import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.Price;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Main {
    public static void main(String[] args) {
        int inputPrice = InputView.printRequirePrice();
        Price price = new Price(inputPrice);

        LottoSeller lottoSeller = new LottoSeller(new LottoNumberGenerator());

        LottoTicket lottoTicket = lottoSeller.buy(price);

        OutputView.printPurchasedLottoTicket(lottoTicket);

        String winningNumbers = InputView.printRequireWinningNumbers();

        LottoGame lottoGame = new LottoGame(price, lottoTicket);
        WinningStatistics winningStatistics = lottoGame.execute(new WinningNumbers(winningNumbers));

        OutputView.printStatistics(winningStatistics);
    }
}
