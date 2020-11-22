package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void addWithPersonalDelimiter() {
        assertThat(stringAdderCalculator.sum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void addWithPersonalDelimiterCrosshatch() {
        assertThat(stringAdderCalculator.sum("//#\n1#2#3")).isEqualTo(6);
    }

    @Test
    void addWithPersonalDelimiterAlphabet() {
        assertThat(stringAdderCalculator.sum("//a\n1a2a3")).isEqualTo(6);
    }

    @Test
    void addWithNegativeOperand() {
        assertThatThrownBy(() -> {
            stringAdderCalculator.sum("-1,2,3");
        }).isInstanceOf(RuntimeException.class);

    }
}
