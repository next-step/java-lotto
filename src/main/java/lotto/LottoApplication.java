package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        int totalLottoCount = InputView.calculateLottoCount();
        int manualLottoCount = InputView.inputManualLottoCount(totalLottoCount);
        int automaticLottoCount = totalLottoCount - manualLottoCount;

        List<List<Integer>> manualLottoNumbers = InputView.inputManualLottoNumbers(manualLottoCount);
        LottoTickets manualLottoTickets = LottoTickets.of(manualLottoNumbers);
        LottoTickets lottoTickets = LottoGenerator.generate(automaticLottoCount);

        ResultView.showLottoTickets(manualLottoTickets, lottoTickets);

        // TODO : WinningTickets
        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();

        LottoGame lottoGame = new LottoGame(lottoTickets, winningNumbers, bonusNumber);
        LottoResult lottoResult = lottoGame.getLottoResult();

        ResultView.showLottoWinningResult(lottoResult);
        ResultView.showLottoWinningRate(lottoResult, totalLottoCount);
    }
}
