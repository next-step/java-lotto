import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    StringAddCalculator split;

    @BeforeEach
    public void setUp() {
        split = new StringAddCalculator();
    }

    @Test
    void emptyString() {
        int result = split.splitAndSum(null);
        assertThat(result).isEqualTo(0);
        result = split.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void stringOne() {
        int result = split.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void stringSeperator1() {
        int result = split.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
        result = split.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void stringSeperator2() {
        int result = split.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }
<<<<<<< HEAD

    @Test
    void notNumberException() {
        assertThatThrownBy(() -> split.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> split.splitAndSum("@,1,3"))
                .isInstanceOf(RuntimeException.class);
    }
=======
>>>>>>> 1f087d48b98e01e814ed1c6e7b30a7f7decf9080
}