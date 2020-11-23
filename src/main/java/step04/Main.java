package step04;

import step04.domain.*;
import step04.view.InputView;
import step04.view.ResultView;

import java.util.List;


public class Main {
    public static void main(String[] args) {
        int payment = InputView.payLotto();
        int countOfManualLottos = InputView.readManualCount();
        LottoCounter lottoCounter = LottoCounter.of(payment, countOfManualLottos);

        List<String> manualLottosNumbers = InputView.readManualLottos(countOfManualLottos);
        Lottos manualLottos = LottoNumberParser.executeByMultiple(manualLottosNumbers);

        ResultView.showCountOfLotto(countOfManualLottos, lottoCounter.getCountOfAutoLotto());

//        Lottos userLottos = Lottos.of(lottoCounter.getCountOfAutoLotto());

//        ResultView.showLottoCount(userLottos.size());
//        ResultView.showLottos(userLottos.getLottos());

//        Lotto winningLotto = LottoNumberParser.execute(InputView.createWinningNumber());
//        LottoBall bonusBall = LottoBall.valueOf(InputView.pickBonusBall());
//        WinningComposer winningComposer = WinningComposer.of(winningLotto, bonusBall);

//        RankCounter rankCounter = winningComposer.calculateMatchOfCount(userLottos);
//        ResultView.showWinningTable(rankCounter);
//        ResultView.showYield( rankCounter.calculateGainRate());
    }
}
