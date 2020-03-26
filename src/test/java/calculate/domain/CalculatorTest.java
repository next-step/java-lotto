package calculate.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    public void constructor() throws Exception {
        //given
        Calculator calculator1 = new Calculator("1:2:3", ":");
        Calculator calculator2 = new Calculator("1:2:3", ":");

        //then
        assertThat(calculator1.equals(calculator2));
    }
}
