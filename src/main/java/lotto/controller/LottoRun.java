package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class LottoRun {
    private static final ResultView resultView = new ResultView();
    private static final InputView inputView = new InputView();

    public static void main(String[] args) {
        Money myMoney = getMonney();

        List<Lotto> myLottos = purchaseLottos(myMoney);

        Lotto winningLotto = getWinningLotto();
        LottoNumber bonusNumber = getBonusNumber(winningLotto);

        Map<RankEnum, Integer> result = insightResult(winningLotto, bonusNumber, myLottos);
        insightYield(myMoney, result);
    }

    private static Money getMonney() {
        int money = inputView.inputMoney();
        return new Money(money);
    }

    private static List<Lotto> purchaseLottos(Money money) {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = lottoMachine.purchaseLottos(money);
        resultView.viewLottos(lottos);

        return lottos;
    }

    private static Lotto getWinningLotto() {
        String winningNumbers = inputView.inputWinningNumber();
        Lotto winningLotto = Lotto.newManual(winningNumbers);
        resultView.viewLottoNumbers(winningLotto);

        return winningLotto;
    }

    private static LottoNumber getBonusNumber(Lotto winningLotto) {
        int bonusNumber = inputView.inputBonusNumber();
        LottoNumber bonusLottoNumber = LottoNumber.newChooseNumber(bonusNumber);

        if (winningLotto.isExistNumber(bonusLottoNumber)) {
            throw new IllegalArgumentException("입력하신 보너스번호는 이미 있는 번호입니다.");
        }
        return bonusLottoNumber;
    }

    private static Map<RankEnum, Integer> insightResult(Lotto winningLotto, LottoNumber bonusNumber, List<Lotto> lottos) {
        LottoInspector lottoInspector = new LottoInspector();
        Map<RankEnum, Integer> result = lottoInspector.getResult(winningLotto, bonusNumber, lottos);

        resultView.viewInspect(result);

        return result;
    }

    private static LottoInspector insightYield(Money money, Map<RankEnum, Integer> result) {
        LottoInspector lottoInspector = new LottoInspector();
        int totalRevenue = lottoInspector.getTotalRevenue(result);
        BigDecimal yield = lottoInspector.getYield(money, totalRevenue);

        resultView.viewInsight(yield);

        return lottoInspector;
    }
}
