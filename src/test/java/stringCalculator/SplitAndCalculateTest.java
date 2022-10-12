package stringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SplitAndCalculateTest {

    @Test
    void 공백() {
        SplitAndCalculate splitAndCalculate = new SplitAndCalculate();
        assertThatIllegalArgumentException().isThrownBy( () ->
                splitAndCalculate.splitAndCalculate(" ")
        );
    }

    @Test
    void 널() {
        SplitAndCalculate splitAndCalculate = new SplitAndCalculate();
        assertThatIllegalArgumentException().isThrownBy( () ->
                splitAndCalculate.splitAndCalculate(null)
        );
    }

    @Test
    void split() {
        SplitAndCalculate splitAndCalculate = new SplitAndCalculate();
        assertThat(splitAndCalculate.splitString("2 + 3")).containsExactly("2","+","3");
    }

    @Test
    void 통합테스트1() {
        SplitAndCalculate splitAndCalculate = new SplitAndCalculate();
        assertThat(splitAndCalculate.splitAndCalculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @Test
    void 통합테스트2() {
        SplitAndCalculate splitAndCalculate = new SplitAndCalculate();
        assertThat(splitAndCalculate.splitAndCalculate("2 + 3")).isEqualTo(5);
    }

    @Test
    void 오류테스트() {
        SplitAndCalculate splitAndCalculate = new SplitAndCalculate();
        assertThatIllegalArgumentException().isThrownBy(
                () -> splitAndCalculate.splitAndCalculate("2 ++ 3")
        );
    }
}
