package com.game.lotto;

import com.game.lotto.count.TicketCount;
import com.game.lotto.money.Money;
import com.game.lotto.number.LottoNumber;
import com.game.lotto.number.ManualLottoNumberGenerator;
import com.game.lotto.number.SelectedLottoNumbers;
import com.game.lotto.play.LottoGame;
import com.game.lotto.ticket.WinnerTicket;
import com.game.lotto.ui.InputView;
import com.game.lotto.ui.ResultView;

import java.util.List;

public class LottoGameApplication {
    public static void main(String[] args) {
        LottoGame lottoGame = getLottoGameByUserInput();
        WinnerTicket winnerTicket = inputWinnerNumbersAndGetWinnerTicket();
        playLottoGameAndPrintResults(lottoGame, winnerTicket);
    }

    private static void playLottoGameAndPrintResults(LottoGame lottoGame, WinnerTicket winnerTicket) {
        ResultView.printGameResult(lottoGame.compareWithWinnerTicketAndGetEarningRates(winnerTicket));
    }

    private static WinnerTicket inputWinnerNumbersAndGetWinnerTicket() {
        List<LottoNumber> winnerNumbers = InputView.inputLastWinnerNumber();
        LottoNumber bonusNumber = InputView.inputBonusNumber();
        WinnerTicket winnerTicket = new WinnerTicket(new ManualLottoNumberGenerator(winnerNumbers), bonusNumber);
        ResultView.printResultMessage();
        return winnerTicket;
    }

    private static LottoGame getLottoGameByUserInput() {
        Money inputPrice = InputView.inputPrice();
        TicketCount manualLottoCount = InputView.inputManualLottoCount();
        List<SelectedLottoNumbers> manualLottoNumbers = InputView.inputManualLottoNumber(manualLottoCount);
        return new LottoGame(inputPrice, manualLottoNumbers);
    }
}
