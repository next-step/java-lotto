package stringaddcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class AdditionStringTest {
    @ValueSource(strings = {
            "1,:3,4,2",     // 숫자 이외
            "1;3,4,2",      // 숫자 이외
            "1,2,3,-1,4"    // 음수
    })
    @ParameterizedTest
    public void intValue_숫자이외_음수(String formula) {
        assertThatThrownBy(() ->
            new AdditionString(formula).intValue()
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void intValue_빈문자열_Null() {
        String[] formulas = new String[] {
                " ", "       ", null
        }
        for (String iFormula : formulas) {
            assertThat(
                    new AdditionString(iFormula).intValue()
            ).isEqualsTo(0);
        }
    }

    @ValueSource(ints = {
            "1",
            "12",
            "123"
    })
    @ParameterizedTest
    public void intValue_숫자하나(int number) {
        assertThat(
                new AdditionString(
                        String.valueOf(number)
                ).intValue()
        ).isEqualsTo(number);
    }

    @CsvSource(value = {
            "1:3,4,2=10"
    }, delimiter = '=')
    @ParameterizedTest
    public void intValue_구분자_콜론(String formula, int result) {
        assertThat(
                new AdditionString(formula).intValue()
        ).isEqualsTo(result);
    }

    @Test
    public void intValue_커스텀구분자() {
        Map<String, Integer> formulaAndResultMap = new HashMap<>();
        formulaAndResultMap.put("//$\n1$2$3,4:5", 15);
        formulaAndResultMap.put("//;\\n1;2;3", 6);

        for (Map.Entry<String, Integer> iEntry : formulaAndResultMap.entrySet()) {
            String iFormula = iEntry.getKey();
            int iResult = iEntry.getValue();

            assertThat(
                    new AdditionString(iFormula).intValue()
            ).isEqualsTo(iResult);
        }
    }
}
