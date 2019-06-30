package lotto;

import lotto.model.*;
import lotto.model.generator.ManualLottoGenerator;
import lotto.model.generator.RandomLottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        int inputOfAmount = InputView.askOfAmount();
        Wallet wallet = new Wallet(Money.won(inputOfAmount));
        List<String> numbersOfManual = InputView.askManualLotto();

        long sizeOfManual = numbersOfManual.size();
        long sizeOfRandom = wallet.countAvailableByLotto() - sizeOfManual;

        LottoTicket lottoTicketByManual = LottoStore.buy(wallet, new ManualLottoGenerator(numbersOfManual));
        LottoTicket lottoTicketByAuto = LottoStore.buy(wallet, new RandomLottoGenerator(sizeOfRandom));

        OutputView.printNumberOfBuyLotto(lottoTicketByManual.countOfLotto(), lottoTicketByAuto.countOfLotto());

        LottoTicket lottoTicket = lottoTicketByAuto.merge(lottoTicketByManual);

        OutputView.printLottoTicket(lottoTicket);

        String inputOfNumbers = InputView.askOfWinningNumbers();
        int inputOfBonusNumber = InputView.askOfWinningBonusNumber();

        WinningLotto winningLotto = WinningLotto.of(inputOfNumbers, inputOfBonusNumber);

        LottoResult result = lottoTicket.result(winningLotto);
        OutputView.printReport(result);
        OutputView.printRateOfReturn(result.getRateOfReturn());

    }
}
