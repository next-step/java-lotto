package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PrizeConditionTest {

    @DisplayName("Test of getting prize condition with matching number count and bonus number")
    @ParameterizedTest
    @CsvSource(value = {
            "3,false:FIFTH",
            "3,true:FIFTH",
            "4,false:FOURTH",
            "4,true:FOURTH",
            "5,false:THIRD",
            "5,true:SECOND",
            "6,false:FIRST",
    }, delimiter = ':')
    void testPrizeCondtion(int matchingNumberCount, boolean bonusIncluded, String nameOfPrize) {
        assertThat(PrizeCondition.of(matchingNumberCount, bonusIncluded)).isEqualTo(PrizeCondition.valueOf(nameOfPrize));
    }
}
