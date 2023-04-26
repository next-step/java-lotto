package study.lotto;

import study.lotto.controller.LottoBundleMaker;
import study.lotto.domain.*;
import study.lotto.view.InputView;
import study.lotto.view.OutputView;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        // 금액 입력
        Integer money = InputView.inputMoney();

        List<Lotto> lottoList = LottoBundleMaker.createLottoList(money);
        LottoBundle lottoBundle = LottoBundleMaker.createLottoBundle(lottoList);
        ScoreBoard scoreBoard = new ScoreBoard(money);

        OutputView.displayLottoBundle(lottoBundle);

        // 로또 정답 입력
        List<Integer> lastWeekNumbers = InputView.inputLastWeekAnswer();
        Lotto lottoAnswer = Lotto.generate(lastWeekNumbers);

        for (Lotto lotto : lottoBundle.getLottos()) {
            Integer score = lotto.getScore(lottoAnswer);
            ScoreType scoreType = ScoreType.of(score); // 어떤 스코어 타입인지...
            scoreBoard.addScore(scoreType); // 스코어 타입에 기록...
        }

        OutputView.displayLottoScore(scoreBoard);
        OutputView.displayRatio(scoreBoard.getRatioOfReturn());
    }
}
