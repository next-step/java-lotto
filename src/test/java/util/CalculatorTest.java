package util;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


public class CalculatorTest {

    @Test
    public void nullToZeroTest() {
        assertThat(Calculator.nullToZero(null)).isEqualTo(0);
    }
}