package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoTotalCalculatorTest {

    @Test
    @DisplayName("6개가 아닌 숫자 체크")
    void checkValidationWinerNumbers() {
        List<Integer> testNumbers = new ArrayList<>();
        testNumbers.add(1);
        testNumbers.add(2);
        testNumbers.add(3);
        testNumbers.add(4);
        testNumbers.add(5);

        LottoTotalCalculator lottoTotalCalculator = new LottoTotalCalculator();
        assertThatIllegalArgumentException().isThrownBy(() -> lottoTotalCalculator.checkValidationWinerNumbers(testNumbers));
    }

    @Test
    @DisplayName("1~45를 넘은 경우 체크")
    void checkValidationWinerNumbers2() {
        List<Integer> testNumbers = new ArrayList<>();
        testNumbers.add(1);
        testNumbers.add(2);
        testNumbers.add(3);
        testNumbers.add(4);
        testNumbers.add(5);
        testNumbers.add(60);

        LottoTotalCalculator lottoTotalCalculator = new LottoTotalCalculator();
        assertThatIllegalArgumentException().isThrownBy(() -> lottoTotalCalculator.checkValidationWinerNumbers(testNumbers));
    }
}