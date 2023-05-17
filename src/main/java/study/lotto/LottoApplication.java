package study.lotto;

import study.lotto.domain.*;
import study.lotto.view.InputView;
import study.lotto.view.OutputView;

import java.util.ArrayList;

import java.util.List;

public class LottoApplication {

    public static void main(String[] args) {
        // 금액 입력
        Integer money = InputView.inputMoney();
        Integer manualCount = InputView.inputManualCount();

        List<Lotto> manualLottoList = new ArrayList<>();
        for (int i = 0; i < manualCount; i++) {
            Lotto lotto = new Lotto(InputView.inputManualLottoNumber());
            manualLottoList.add(lotto);
        }

        LottoBundle lottoBundle = LottoBundle.createByMoney(money, manualLottoList);
        ScoreBoard scoreBoard = new ScoreBoard(money);

        OutputView.displayAutoAndManualCount(money / LottoBundle.PRICE_PER_SHEET, manualCount);
        OutputView.displayLottoBundle(lottoBundle);

        // 로또 정답 입력
        List<Integer> lastWeekNumbers = InputView.inputLastWeekAnswer();
        Lotto lottoAnswer = Lotto.generate(lastWeekNumbers);
        Bonus bonus = new Bonus(InputView.inputBonusNumber(), lastWeekNumbers);
        bonus.validate(lastWeekNumbers);

        // 결과 계산
        for (Lotto lotto : lottoBundle.getLottos()) {
            ScoreType scoreType = lotto.getScoreType(lottoAnswer, bonus); // 어떤 스코어 타입인지...
            scoreBoard.addScore(scoreType); // 스코어 타입에 기록...
        }

        OutputView.displayLottoScore(scoreBoard);
        OutputView.displayRatio(scoreBoard.getRatioOfReturn());
    }
}
