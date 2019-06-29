package edu.nextstep.step4;

import edu.nextstep.step4.domain.Number;
import edu.nextstep.step4.domain.*;
import edu.nextstep.step4.view.InputView;
import edu.nextstep.step4.view.ResultView;

import java.util.ArrayList;
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
    private static final int CHECK_MANUAL_LOTTO = 0;
    public static void main(String[] args) {
        LottoApplication app = new LottoApplication();
        app.run();
    }

    public void run() {
        // 금액 투입
        int inputMoney = InputView.inputMoney();
        // 수동생성 개수
        int manualCount = InputView.inputManualCount();
        // Money 객체 생성
        Money money = new Money(inputMoney);

        // 수동생성 있을 경우 입력받기
        List<String> manualLottos = new ArrayList<>();
        if (manualCount > CHECK_MANUAL_LOTTO) {
            manualLottos = InputView.inputManualNumber(manualCount);
        }

        // 수동생성, 자동생성 개수 출력
        InputView.printExtractNumber(manualCount, money.getAutoNumber(manualCount));

        // 투입 금액에 따른 로또 개수발행
        Lottos lottosTikets = LottoStore.publishLotto(money, manualLottos);

        // 발행된 로또 출력
        ResultView.printLottoInfo(lottosTikets);

        // 당첨번호 + 보너스 번호 객체
        Lotto lottery = Lotto.createLotteryNumber(InputView.inputLotteryNumber());
        int number = Integer.parseInt(InputView.inputBonusNumber());
        Number bonusNumber = Number.of(number);
        WinLotto winLotto = WinLotto.of(lottery, bonusNumber);

        // 보너스 번호와 당첨번호 중복 여부 확인
        if (lottery.contains(bonusNumber)) {
            throw new IllegalArgumentException("중복된 번호 입니다.");
        }

        // 당첨내역 출력
        WinInfo winInfo = lottosTikets.getLotteryLottoNumberResultCount(winLotto);
        winInfo = lottosTikets.addBonusNumberMatchLotto(winInfo, winLotto);
        ResultView.printLotteryCount(winInfo);

        // 당첨 금액
        double income = lottosTikets.fetchIncome(winInfo, money);
        ResultView.printIncome(income);
    }
}
