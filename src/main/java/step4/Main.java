package step4;

import step4.VO.Lottos;
import step4.VO.ManualLottoCnt;
import step4.VO.ManualLottoNumbers;
import step4.VO.Money;
import step4.View.InputView;
import step4.View.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public void main(String[] args) {
        Money money = new Money(InputView.getMoney());
        LottoGenerator lottoGenerator = new LottoGenerator();

        Lottos lottos = new Lottos();

        // 수동 발권 로직
        ManualLottoCnt manualCnt = new ManualLottoCnt(InputView.getManualLotto(), money);

        List<ManualLottoNumbers> manualLottoNumbersList = new ArrayList<>();
        for(int i = 0; i < manualCnt.getManualLottoCnt(); i++) {
            manualLottoNumbersList.add(new ManualLottoNumbers(InputView.getManualLottoNumbers()));
        }

        lottos.buyManualLottos(manualLottoNumbersList);
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
        lottos.buyAutoLottos(money, lottoGenerator);

        ResultView.printLottoCnt(lottos.getLottosCnt());
        ResultView.printLottoList(lottos);
    }
}
