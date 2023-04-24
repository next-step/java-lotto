package study.lotto;

import study.lotto.domain.Lotto;
import study.lotto.domain.LottoBundle;
import study.lotto.domain.LottoScoreType;
import study.lotto.domain.LottoScore;
import study.lotto.view.InputView;
import study.lotto.view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {
        Integer money = InputView.inputMoney();

        LottoBundle lottoBundle = LottoBundle.createLottoBundle(money);

        OutputView.displayLottoBundle(lottoBundle);

        Lotto lottoAnswer = Lotto.generate(InputView.inputLastWeekAnswer());


        LottoScore lottoScore = LottoScore.generate();
        for (Lotto lotto : lottoBundle.getLottos()) {
            Integer score = lotto.getScore(lottoAnswer);
            LottoScoreType lottoScoreType = LottoScoreType.of(score);
            lottoScore.addScore(lottoScoreType);
        }

        OutputView.displayLottoScore(lottoScore);
        OutputView.displayRatio(money, lottoScore);
    }
}
