package edu.nextstep.step2;

import edu.nextstep.step2.utils.RandomNumberUtils;
import edu.nextstep.step2.view.InputView;
import edu.nextstep.step2.domain.LotteryNumber;
import edu.nextstep.step2.domain.Lotto;
import edu.nextstep.step2.domain.Money;
import edu.nextstep.step2.view.ResultView;

import java.util.List;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-25 01:02
 */
public class LottoApplication {
    public static void main(String[] args) {
        LottoApplication app = new LottoApplication();
        app.run();
    }

    public void run() {
        // 금액 투입
        Money money = InputView.inputMoney();

        // 투입 금액에 따른 로또 개수발행
        Lotto lotto = RandomNumberUtils.getLotto(money);

        // 발행된 로또 출력
        ResultView.printLottoInfo(lotto);

        // 당첨 번호
        LotteryNumber lotteryNumber = InputView.inputLotteryNumber();

        // 당첨 카운트
        List<Integer> matchCount = lotto.getMatchCountExtractNumberFromLotteryNumber(lotteryNumber);

        // 당첨내역 출력
        ResultView.printResult(matchCount, money);
    }
}
