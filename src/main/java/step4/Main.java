package step4;

import step4.VO.*;
import step4.View.InputView;
import step4.View.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public void main(String[] args) {
        // 금액 입력
        Money money = new Money(InputView.getMoney());
        // 로또 생성기 선언
        LottoGenerator lottoGenerator = new LottoGenerator();

        Lottos lottos = new Lottos();

        // 수동 발권 로직 시작
        // 수동 발권 갯수 입력
        ManualLottoCnt manualCnt = new ManualLottoCnt(InputView.getManualLotto(), money);

        List<Lotto> manualLottoNumbersList = new ArrayList<>();
        for(int i = 0; i < manualCnt.getManualLottoCnt(); i++) {
            // 수동 발권 번호 입력
            manualLottoNumbersList.add(new Lotto(InputView.getManualLottoNumbers()));
        }

        LottoStore.buyManualLottos(lottos, manualLottoNumbersList);
        buyAutoLottos(lottos, money, lottoGenerator);

        ResultNumber resultNumber = new ResultNumber(InputView.getResultNumber(), InputView.getBonusNumber());

        Statistic statistic = new Statistic();
        lottos.checkResult(statistic, resultNumber);

        // 결과 출력
        ResultView.printResult(money, statistic);
    }

    public void buyAutoLottos(Lottos lottos, Money money, LottoGenerator lottoGenerator) {
        LottoStore.buyAutoLottos(lottos, money, lottoGenerator);

        ResultView.printLottoCnt(lottos.getLottosCnt());
        ResultView.printLottoList(lottos);
    }
}
