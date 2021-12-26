package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class NumberTest {
    @ParameterizedTest
    @CsvSource({"-1", "0", "100"})
    @DisplayName("비 정상적인 값으로 Number이 생성될때 illegalArgumentException이 발생하는지 확인합니다.")
    void illegalArgument(int number) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> {new Number(number);}
        );
    }

    @ParameterizedTest
    @CsvSource({"1,1","2,0"})
    @DisplayName("주어진 숫자가 같으면 1 증가한 기준이 되고, 아니면 변하지 않은 기준이 되는지 확인합니다.")
    void matchResult(int winnerNumberValue, int matchedCriteriaValue) {
        //given
        Number thisNumber = new Number(1);
        Number winnerNumber = new Number(winnerNumberValue);
        Criteria criteria = new Criteria(0);

        //when
        Criteria resultCriteria = thisNumber.matchResult(winnerNumber, criteria);
        //then
        assertThat(resultCriteria.equals(new Criteria(matchedCriteriaValue))).isTrue();
    }
}