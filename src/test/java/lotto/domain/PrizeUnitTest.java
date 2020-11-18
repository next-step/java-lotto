package lotto.domain;

import lotto.LottoErrorMessage;
import org.junit.jupiter.api.Assertions;
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
            PrizeUnit.findPrizeFieldByUnitCount(2);
        }).withMessageContaining(LottoErrorMessage.NOT_PRIZE_UNIT.getErrorMessage());
    }

    @DisplayName("당첨금액 계산 Test")
    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000","6:2000000000"}, delimiter = ':')
    void calculationTest(String prizeUnitCountValue, String expectValue){
        Long prize = PrizeUnit.calculate(Integer.parseInt(prizeUnitCountValue), 1);
        assertEquals(expectValue, String.valueOf(prize));
    }
}
