package lotto;

import lotto.domain.*;
import lotto.domain.LottoNumberGenerator;
import lotto.domain.RandomNumberGeneratorStrategy;
import lotto.view.InputView;
import lotto.view.PrintView;

import java.util.List;

public class LottoGame {

    private final InputView inputView = new InputView();
    private final PrintView printView = new PrintView();

    public static void main(String[] args) {
        new LottoGame().start();
    }

    private void start() {
        LottoWallet lottoWallet = buyingLotto();

        lottery(lottoWallet.takeOutLottoTickets());
    }

    private LottoWallet buyingLotto() {
        LottoWallet lottoWallet = buyingLottoTickets();
        printView.showStatusBuyTicket(lottoWallet);
        return lottoWallet;
    }

    private void lottery(List<LottoTicket> lottoTickets) {
        WinnerNumbers winnerNumbers = generatorWinnerNumber();

        WinnerStatistics winnerStatistics = WinnerStatistics.create(lottoTickets, winnerNumbers);

        printView.showLottoResult(winnerStatistics);
    }

    private WinnerNumbers generatorWinnerNumber() {
        List<LottoNumber> lottoNumbers = getWinnerLottoNumbers();
        LottoNumber bonusNumber = getBonusLottoNumber();

        WinnerNumbers winnerNumbers = WinnerNumbers.create(lottoNumbers, bonusNumber);
        return winnerNumbers;
    }

    private LottoNumber getBonusLottoNumber() {
        int inputBonusNumber = inputView.inputBonusNumber();
        LottoNumber bonusNumber = LottoNumber.create(inputBonusNumber);
        return bonusNumber;
    }

    private List<LottoNumber> getWinnerLottoNumbers() {
        List<String> inputWinnerNumbers = inputView.inputWinnerNumber();

        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        List<LottoNumber> lottoNumbers = lottoNumberGenerator.generator(inputWinnerNumbers);
        return lottoNumbers;
    }

    private LottoWallet buyingLottoTickets() {
        Money money = inputView.inputMoneyForBuyTicket();
        int countOfManualLottoTicket = inputView.inputCountOfManualLottoTicket();
        LottoWallet lottoWallet = LottoWallet.create(money, countOfManualLottoTicket);

        List<List<String>> manualNumbers = inputView.inputManualNumbers(countOfManualLottoTicket);

        lottoWallet.buyingLotto(new RandomNumberGeneratorStrategy(), manualNumbers);
        return lottoWallet;
    }
}
