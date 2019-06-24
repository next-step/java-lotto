package edu.nextstep.step2;

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

        // 당첨 이력
        List<Integer> matchCount = lotto.getMatchCountExtractNumberFromLotteryNumber(lotteryNumber);


    }
}
