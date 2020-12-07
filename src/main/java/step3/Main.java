package step3;

import step3.VO.Lottos;
import step3.View.InputView;
import step3.View.ResultView;
import step3.VO.LottoNumber;
import step3.VO.Money;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public void main(String[] args) {
        Money money = new Money(InputView.getMoney());

        LottoGenerator lottoGenerator = new LottoGenerator();

        Lottos lottos = settingLottos(money, lottoGenerator);
        ResultNumber resultNumber = new ResultNumber();

        resultNumber.settingLottoResultNumber(InputView.getResultNumber());
        resultNumber.settingLottoBonusNumber(InputView.getBonusNumber());

        Statistic statistic = new Statistic();
        lottos.checkResult(statistic, resultNumber);

        // 결과 출력
        ResultView.printResult(money, statistic);
    }

    public Lottos settingLottos(Money money, LottoGenerator lottoGenerator) {
        Lottos lottos = new Lottos(money, lottoGenerator);

        ResultView.printLottoCnt(lottos.getLottosCnt());

        ResultView.printLottoList(lottos);

        return lottos;
    }
}
