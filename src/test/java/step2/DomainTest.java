package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DomainTest {
    @Test
    @DisplayName("전체 도메인 테스트")
    void MainTest(){
        int money = 10000;
        FixedNumberGenerator fixedWinningsGenerator = new FixedNumberGenerator();
        fixedWinningsGenerator.setNumber("1,3,5,7,10,12");

        Lottos lottos = Main.settingLottos(money, fixedWinningsGenerator);

        String resultString = "1, 3, 5, 7, 9, 11";

        Main.checkResult(lottos, resultString);
        // 결과 입력
        Statistic.recordResult(lottos);
        // 결과 출력
        ResultView.printResult(lottos, money);
    }
}
