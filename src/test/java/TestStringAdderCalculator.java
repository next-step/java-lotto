import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestStringAdderCalculator {
    private StringAdderCalculator stringAdderCalculator;

    @BeforeEach
    void setUp() {
        stringAdderCalculator = new StringAdderCalculator();
    }

    @Test
    void addEmptyString() {
        assertThat(stringAdderCalculator.sum("")).isEqualTo(0);
    }

    @Test
    void addNull() {
        assertThat(stringAdderCalculator.sum(null)).isEqualTo(0);
    }

    @Test
    void addWithOneOperand() {
        assertThat(stringAdderCalculator.sum("1")).isEqualTo(1);
    }

    @Test
    void addWithTwoOperand() {
        assertThat(stringAdderCalculator.sum("1,2")).isEqualTo(3);
    }


    @Test
    void addWithThreeOperandAndCommaAndColonDelimiter() {
        assertThat(stringAdderCalculator.sum("1,2:3")).isEqualTo(6);
    }

    //TODO : user define delimiter

    @Test
    void addWithPersonalDelimiter() {
        assertThat(stringAdderCalculator.sum("//;\n1;2;3")).isEqualTo(6);
    }
}
