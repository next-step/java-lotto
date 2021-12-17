package step2;

import step2.domain.*;
import step2.dto.WinningLotto;
import step2.dto.WinningRate;
import step2.service.LottoGame;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoGameMain {

    public static void main(String[] args) {
        Money inputAmount = InputView.inputAmount();

        LottoTickets lottoTickets = LottoGame.generateLotto(inputAmount);
        ResultView.renderLottoStatus(lottoTickets);

        MatchedNumber matchedNumber = new MatchedNumber(InputView.pickWinningNumber());
        int bonusBallNumber = InputView.pickBonusBallNumber();
        WinningResultInfo resultInfo = lottoTickets.matchedWinningNumber(new WinningLotto(matchedNumber, bonusBallNumber));

        ResultView.renderWinningResult(resultInfo);

        WinningRate winningRate = resultInfo.calculateRate(inputAmount);
        ResultView.renderWinningRate(winningRate, winningRate.lessThanBaseRate());
    }
}
