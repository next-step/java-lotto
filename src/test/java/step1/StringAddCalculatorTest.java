package step1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringAddCalculatorTest{
    private StringAddCalculator cal;

    @BeforeEach
    public void setup() {
        cal = new StringAddCalculator();
    }

    @Test
    public void add_숫자하나() throws Exception {
        int[] onlyOneInputNumber = {1};
        assertThat(cal.add(onlyOneInputNumber)).isEqualTo(1);
    }

    @Test
    public void add_쉼표구분자() throws Exception {
        int[] basicSplitInputNumber = {1, 2};
        assertThat(cal.add(basicSplitInputNumber)).isEqualTo(3);
    }

    @Test
    public void add_쉼표_또는_콜론_구분자() throws Exception {
        int[] basicSplitInputNumber = {1, 2, 3};
        assertThat(cal.add(basicSplitInputNumber)).isEqualTo(6);
    }

    @Test
    public void add_custom_구분자() throws Exception {
        int[] basicSplitInputNumber = {1, 2, 3};
        assertThat(cal.add(basicSplitInputNumber)).isEqualTo(6);
    }

    @Test
    public void add_negative() throws Exception {
        int[] basicSplitInputNumber = {-1, 2, 3};
        assertThatIllegalArgumentException().isThrownBy(() -> {
            cal.add(basicSplitInputNumber);
        });
    }

}