package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.VO.Lotto;
import step4.VO.Lottos;
import step4.VO.ManualLottoCnt;
import step4.VO.Money;
import step4.View.ResultView;

import java.util.ArrayList;
import java.util.List;

public class DomainTest {
    @Test
    @DisplayName("전체 도메인 테스트")
    void MainTest(){
        Money money = new Money(10000);
        FixedNumberGenerator fixedWinningsGenerator = new FixedNumberGenerator();
        fixedWinningsGenerator.setNumber("1,3,5,7,10,12");

        FixedNumberGenerator manualLottoNumbers = new FixedNumberGenerator();
        manualLottoNumbers.setNumber("1,3,5,6,9,11");

        Main main = new Main();

        Lottos lottos = new Lottos();

        // 수동 발권 로직
        ManualLottoCnt manualCnt = new ManualLottoCnt(3, money);

        List<Lotto> manualLottoNumbersList = new ArrayList<>();
        for(int i = 0; i < manualCnt.getManualLottoCnt(); i++) {
            manualLottoNumbersList.add(new Lotto(manualLottoNumbers.getLottoNumbers()));
        }

        lottos.buyManualLottos(manualLottoNumbersList);

        // 자동발권
        main.buyAutoLottos(lottos, money, fixedWinningsGenerator);

        // 당첨 결과
        Statistic statistic = new Statistic();
        ResultNumber resultNumber = new ResultNumber("1, 3, 5, 7, 10, 11", "12");

        lottos.checkResult(statistic, resultNumber);

        // 결과 출력
        ResultView.printResult(money, statistic);
    }
}
