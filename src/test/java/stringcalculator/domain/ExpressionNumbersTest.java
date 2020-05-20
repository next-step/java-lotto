package stringcalculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringcalculator.domain.vo.Number;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ExpressionNumbersTest {

    @DisplayName("멤버 변수로 들고있는 Number의 총합을 구한다.")
    @Test
    void sumAllNumbers() {
        ExpressionNumbers expressionNumbers = new ExpressionNumbers(Arrays.asList("1", "2", "3"));

        Number actualResult = expressionNumbers.sumAllNumbers();

        assertThat(actualResult).isEqualTo(6);
    }
}