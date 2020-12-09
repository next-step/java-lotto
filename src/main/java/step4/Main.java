package step4;

import step4.VO.Lottos;
import step4.VO.Money;
import step4.View.InputView;
import step4.View.ResultView;

public class Main {

    public void main(String[] args) {
        Money money = new Money(InputView.getMoney());

        LottoGenerator lottoGenerator = new LottoGenerator();

        Lottos lottos = new Lottos();

        buyAutoLottos(lottos, money, lottoGenerator);

        ResultNumber resultNumber = new ResultNumber();

        resultNumber.settingLottoResultNumber(InputView.getResultNumber());
        resultNumber.settingLottoBonusNumber(InputView.getBonusNumber());

        Statistic statistic = new Statistic();
        lottos.checkResult(statistic, resultNumber);

        // 결과 출력
        ResultView.printResult(money, statistic);
    }

    public void buyAutoLottos(Lottos lottos, Money money, LottoGenerator lottoGenerator) {
        lottos.buyAutoLotto(money, lottoGenerator);

        ResultView.printLottoCnt(lottos.getLottosCnt());
        ResultView.printLottoList(lottos);
    }
}
