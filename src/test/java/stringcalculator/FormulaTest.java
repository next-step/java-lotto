package stringcalculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class FormulaTest {

    @ParameterizedTest
    @CsvSource(value = {"+:13", "-:-5", "*:96", "/:0"}, delimiter = ':')
    void CalulateTest(String oper, int result) {
        Formula formula = new Formula(List.of(4, 2, 3, 4), List.of(oper, oper, oper));
        int calculate = formula.calculate();
        assertThat(calculate).isEqualTo(result);
    }

}