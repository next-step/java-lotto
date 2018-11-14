package view;

import domain.*;

import java.util.List;

public class LottoConsole {
    public static void main(String[] args) {
        int money = InputView.getInputNumber("구매금액을 입력해 주세요.");
        LottoGame lottoGame = new LottoGame();
        lottoGame.buyLotto(money);
        List<Lotto> lottos = lottoGame.getBoughtLottos();
        ResultView.showBoughtLottos(lottos);

        String lottoWinningNumbers = InputView.getInputString("지난 주 당첨 번호를 입력해 주세요.");
        int bonusNumber = InputView.getInputNumber("보너스 볼을 입력해 주세요.");

        LottoStatistics lottoStatistics = new LottoStatistics(lottoWinningNumbers, bonusNumber);
        LottoResult lottoResult = lottoStatistics.match(lottos);
        ResultView.showResult(lottoResult);
    }
}
