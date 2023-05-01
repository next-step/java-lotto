package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        LottoTickets lottoTickets = issueLottoTickets();
        WinningTicket winningTicket = inputWinningTickets();

        LottoGame lottoGame = new LottoGame(lottoTickets, winningTicket);
        LottoResult lottoResult = lottoGame.getLottoResult();

        ResultView.showLottoWinningResult(lottoResult);
        ResultView.showLottoWinningRate(lottoResult, lottoTickets);
    }

    private static LottoTickets issueLottoTickets() {
        int totalLottoCount = InputView.calculateLottoCount();
        List<List<Integer>> manualLottoNumbers = InputView.inputManualLottoNumbers(totalLottoCount);

        LottoTickets lottoTickets = LottoGenerator.issue(totalLottoCount, manualLottoNumbers);
        ResultView.showLottoTickets(lottoTickets);

        return lottoTickets;
    }

    private static WinningTicket inputWinningTickets() {
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();

        return WinningTicket.of(winningNumbers, bonusNumber);
    }
}
