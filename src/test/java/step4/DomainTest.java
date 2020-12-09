package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.VO.Lottos;
import step4.VO.Money;
import step4.View.ResultView;

public class DomainTest {
    @Test
    @DisplayName("전체 도메인 테스트")
    void MainTest(){
        Money money = new Money(10000);
        FixedNumberGenerator fixedWinningsGenerator = new FixedNumberGenerator();
        fixedWinningsGenerator.setNumber("1,3,5,7,10,12");

        Main main = new Main();

        Lottos lottos = new Lottos();
        main.buyAutoLottos(lottos, money, fixedWinningsGenerator);

        Statistic statistic = new Statistic();
        ResultNumber resultNumber = new ResultNumber();

        resultNumber.settingLottoResultNumber("1, 3, 5, 7, 10, 11");
        resultNumber.settingLottoBonusNumber("12");

        lottos.checkResult(statistic, resultNumber);

        // 결과 출력
        ResultView.printResult(money, statistic);
    }
}
