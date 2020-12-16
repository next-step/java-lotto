package lotto;

import lotto.domain.LottoGame;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        LottoMachine lottoMachine = new LottoMachine();
        // 로또 생성
        LottoTickets lottoTickets = lottoGame.generateLottoTickets(InputView.lottoStart(), lottoMachine);
        OutputView.lottoStatus(lottoTickets);
        // 당첨 로또 생성
        WinningNumber winningNumber = lottoGame.generateWinningNumber(InputView.winningNumber(), lottoMachine);
        // 로또 게임 결과 생성
        LottoResult lottoResult = lottoGame.result(lottoTickets, winningNumber);
        OutputView.LottoEnd(lottoResult);
    }
}
