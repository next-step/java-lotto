package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class PrizeUnitTest {

    @DisplayName("당첨 기준 유닛이 아닌 경우 Exception 테스트")
    @Test
    void notPrizeUnitExceptionTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            PrizeUnit.findPrizeFieldByUnitCount(2, false);
        }).withMessageContaining(LottoErrorMessage.NOT_PRIZE_UNIT.getErrorMessage());
    }

    @DisplayName("당첨금액 계산 Test")
    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000","6:2000000000"}, delimiter = ':')
    void calculationTest(String prizeUnitCountValue, String expectValue){
        PrizeUnit prizeUnit = PrizeUnit.findPrizeFieldByUnitCount(Integer.parseInt(prizeUnitCountValue), false);
        Long prize = prizeUnit.calculate( 1);
        assertEquals(expectValue, String.valueOf(prize));
    }

    @DisplayName("2등 당첨 테스트(보너스 번호)")
    @Test
    void calculationBonusWinTest(){
        PrizeUnit prizeUnit = PrizeUnit.findPrizeFieldByUnitCount(PrizeUnit.SECOND_GRADE.prizeUnitCount, true);
        Long prize = prizeUnit.calculate(1);
        assertEquals(PrizeUnit.SECOND_GRADE.prizeUnitMoney, prize);
    }
}
