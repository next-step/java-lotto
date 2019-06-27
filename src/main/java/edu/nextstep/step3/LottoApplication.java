package edu.nextstep.step3;

import edu.nextstep.step3.domain.Lotto;
import edu.nextstep.step3.domain.LottoNumber;
import edu.nextstep.step3.domain.LottoStore;
import edu.nextstep.step3.domain.Money;
import edu.nextstep.step3.domain.Number;
import edu.nextstep.step3.view.InputView;
import edu.nextstep.step3.view.ResultView;

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
        Lotto lottoTikets = LottoStore.publishLotto(money);

        // 발행된 로또 출력
        ResultView.printLottoInfo(lottoTikets);

        // 당첨 번호
        String lotto = InputView.inputLotteryNumber();
        LottoNumber lottery = LottoNumber.createLotteryNumber(lotto);

        // 보너스 번호
        String bonus = InputView.inputBonusNumber();
        Number bonusNumber = new Number(Integer.parseInt(bonus));

        // 보너스 번호와 당첨번호 중복 여부 확인
        if (lottery.contains(bonusNumber.getNumber())) {
            throw new IllegalArgumentException("중복된 번호 입니다.");
        }

        // 당첨내역 출력
        Map<LottoNumber, Rank> incomeInfo = lottoTikets.addBonusNumberMatchLotto(lottoTikets.getLotteryLottoNumberResultCount(lottery), bonusNumber);
        ResultView.printLotteryCount(incomeInfo);

        // 당첨 금액
        double income = (double) lottoTikets.fetchIncome(incomeInfo) / (double) money.getInputMoney();
        ResultView.printIncome(income);
    }
}
