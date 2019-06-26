package edu.nextstep.step3;

import edu.nextstep.step3.domain.Lotto;
import edu.nextstep.step3.domain.LottoNumber;
import edu.nextstep.step3.domain.Money;
import edu.nextstep.step3.utils.RandomNumberUtils;
import edu.nextstep.step3.view.InputView;
import edu.nextstep.step3.view.ResultView;

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
        Money money = new Money(InputView.inputMoney());
        InputView.printExtractNumber(money.getNumberOfExtract());

        // 투입 금액에 따른 로또 개수발행
        Lotto lotto = RandomNumberUtils.getLotto(money);

        // 발행된 로또 출력
        ResultView.printLottoInfo(lotto);

        // 당첨 번호
        String lotteryNumber = InputView.inputLotteryNumber();
        LottoNumber lottery = LottoNumber.createLotteryNumber(lotteryNumber);

        // 당첨 카운트
        List<Integer> matchCount = lotto.getMatchCountExtractNumberFromLotteryNumber(lottery);

        // 당첨내역 출력
        ResultView.printLotteryCount(lotto.getIncomeMatchCount(lottery));

        // 당첨 금액
        ResultView.printIncome(lotto.sumIncome(matchCount, money));
    }
}
