package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step4.VO.Lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultNumberTest {
    @Test
    @DisplayName("Result Number Test")
    void CheckResultNumberTest() {
        ResultNumber resultNumber = new ResultNumber();

        resultNumber.settingLottoResultNumber("1, 3, 5, 7, 9, 11");

        Lotto lotto = getLotto();
        assertThat(resultNumber.checkLottoResult(lotto.numberList)).isEqualTo(6);
    }

    @Test
    @DisplayName("Result bonus number test")
    void CheckBonusNumberTest() {
        ResultNumber resultNumber = new ResultNumber();

        resultNumber.settingLottoBonusNumber("11");

        Lotto lotto = getLotto();
        assertThat(resultNumber.checkBonusResult(lotto.numberList)).isTrue();

    }

    public Lotto getLotto() {
        FixedNumberGenerator fixedNumberGenerator = new FixedNumberGenerator();
        fixedNumberGenerator.setNumber("1,3,5,7,9,11");

        return new Lotto(fixedNumberGenerator.getLottoNumbers());
    }

}
