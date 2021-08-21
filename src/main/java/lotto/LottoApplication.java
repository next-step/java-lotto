package lotto;

import lotto.common.AutoNumberGenerator;
import lotto.domain.*;
import lotto.exception.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.util.StringUtil.split;
import static lotto.view.InputView.*;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();

        Money money = getMoney();

        LottoCount lottoCount = LottoCount.from(money);

        LottoCount manualLottoCount = getManualLottoCount(lottoCount);

        int autoLottoCount = lottoCount.getAutoLottoCount(manualLottoCount);

        Lottos manualLottos = buyManualLottos(manualLottoCount);

        Lottos autoLottos = lottoMachine.generateLottos(autoLottoCount, new AutoNumberGenerator());

        manualLottos.mergeLottos(autoLottos);

        ResultView resultView = new ResultView();
        resultView.printLottos(manualLottos, autoLottoCount);

        String[] split = split(getWinningNumber());
        List<Integer> winningNumbers = Stream.of(split).map(Integer::valueOf).collect(Collectors.toList());

        Lotto winningLottoNumbers = Lotto.from(winningNumbers);

        LottoNumber bonusNumber = new LottoNumber(Integer.parseInt(askBonusNumber()));

        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        WinningStatistics winningStatistics = new WinningStatistics(manualLottos, winningLotto);

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

    public static LottoCount getManualLottoCount(LottoCount lottoCount) {
        try {
            return LottoCount.of(askManualLottoCount(), lottoCount);
        } catch (LottoNumberCountException e) {
            System.out.println("수동으로 구매할 로또 개수 잘못 입력함. \n");
            return getManualLottoCount(lottoCount);
        }
    }

    public static Lottos buyManualLottos(LottoCount manualLottoCount) {
         List<Lotto> lottos = new ArrayList<>();
         for (int i = 0; i < manualLottoCount.getCount(); i++) {
                lottos.add(getManualLotto());
            }
            return new Lottos(lottos);
    }

    public static Lotto getManualLotto() {
        try {
            return Lotto.from(getAskManualLottoNumber());
        } catch (LottoNumberLengthException e) {
            System.err.println(e);
            return getManualLotto();
        } catch (LottoNumberDuplicateException e) {
            System.err.println(e);
            return getManualLotto();
        }
    }


}
