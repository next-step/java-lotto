package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.VO.Lotto;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void createTest() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        Lotto lotto = new Lotto(lottoGenerator);
        assertThat(lotto.numberList.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 당첨 여부 테스트")
    void checkRewardTest() {
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator();
        fixedNumberGenerator.setNumber("1,3,5,7,9,11");

        Lotto lotto = new Lotto(fixedNumberGenerator);
        Statistic statistic = new Statistic();
        ResultNumber resultNumber = new ResultNumber();

        resultNumber.settingLottoResultNumber("1, 3, 5, 7, 9, 10");
        resultNumber.settingLottoBonusNumber("11");

        lotto.checkReward(statistic, resultNumber);

        // Statistic.results[1] = 2등 갯수
        assertThat(statistic.getResultByIndex(1)).isEqualTo(1);
    }
}
