package lotto;

import lotto.common.AutoNumberGenerator;
import lotto.domain.*;
import lotto.exception.*;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import static lotto.view.InputView.*;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        Money money = getMoney();

        LottoCount lottoCount = LottoCount.from(money);

        LottoCount manualLottoCount = getManualLottoCount(money);

        Lottos manualLottos = buyManualLottos(manualLottoCount);

        int autoLottoCount = lottoCount.getAutoLottoCount(manualLottoCount);
        Lottos autoLottos = lottoMachine.generateLottos(autoLottoCount, new AutoNumberGenerator());

        Lottos totalLottos = manualLottos.mergeLottos(autoLottos);

        ResultView resultView = new ResultView();
        resultView.printLottos(totalLottos, autoLottoCount);

        Lotto winningLottoNumbers = getManualLotto(getWinningNumber());

        LottoNumber bonusNumber = new LottoNumber(Integer.parseInt(askBonusNumber()));

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        WinningStatistics winningStatistics = new WinningStatistics(totalLottos, winningLotto);

        resultView.printSameNumbers(winningStatistics);
    }

    public static Money getMoney() {
        try {
            return new Money(askPurchasePrice());
        } catch (LottoPurchaseAmountException e) {
            System.out.println("로또 구입 금액이 잘못 되었습니다.\n");
            return getMoney();
        }
    }

    public static LottoCount getManualLottoCount(Money money) {
        try {
            return LottoCount.of(askManualLottoCount(), money);
        } catch (LottoNumberCountException e) {
            System.out.println("수동으로 구매할 로또 개수 잘못 입력함. \n");
            return getManualLottoCount(money);
        }
    }

    public static Lottos buyManualLottos(LottoCount manualLottoCount) {
         List<Lotto> lottos = new ArrayList<>();
         for (int i = 0; i < manualLottoCount.getCount(); i++) {
             List<Integer> askManualLottoNumber = getAskManualLottoNumber();
             lottos.add(getManualLotto(askManualLottoNumber));
            }
            return new Lottos(lottos);
    }

    public static Lotto getManualLotto(List<Integer> lottoNumber) {
        try {
            return Lotto.from(lottoNumber);
        } catch (LottoNumberLengthException | LottoNumberDuplicateException e) {
            System.err.println(e);
            return getManualLotto(lottoNumber);
        } 
    }


}
