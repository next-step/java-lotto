package StringAddCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberTest {


    @Test
    public void NumberTest() {
        Number five = new Number(5);
        Number two = new Number(2);
        Number seven = five.add(two);

        assertThat(seven.getNumber()).isEqualTo(7);

        Number six = new Number(6);
        Number three = new Number(3);
        Number nine = six.add(three);

        assertThat(nine.getNumber()).isEqualTo(9);
    }
}
