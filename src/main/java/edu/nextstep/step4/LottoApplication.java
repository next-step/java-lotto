package edu.nextstep.step4;

import edu.nextstep.step4.domain.Number;
import edu.nextstep.step4.domain.*;
import edu.nextstep.step4.enums.Rank;
import edu.nextstep.step4.view.InputView;
import edu.nextstep.step4.view.ResultView;

import java.util.Map;

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
        Lottos lottosTikets = LottoStore.publishLotto(money);

        // 발행된 로또 출력R
        ResultView.printLottoInfo(lottosTikets);

        // 당첨 번호
        Lotto lottery = Lotto.createLotteryNumber(InputView.inputLotteryNumber());
        // 보너스 번호
        Number bonusNumber = Number.of(InputView.inputBonusNumber());
        // 당첨번호 + 보너스 번호 객체
        WinLotto win = WinLotto.of(lottery, bonusNumber);

        // 보너스 번호와 당첨번호 중복 여부 확인
        if (lottery.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("중복된 번호 입니다.");
        }

        // 당첨내역 출력
        WinInfo winInfo = lottosTikets.addBonusNumberMatchLotto(
                lottosTikets.getLotteryLottoNumberResultCount(lottery), bonusNumber);

        ResultView.printLotteryCount(winInfo);

        // 당첨 금액
        double income = (double) lottosTikets.fetchIncome(winInfo) / (double) money.getInputMoney();
        ResultView.printIncome(income);
    }
}
