package StringCalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.*;
public class AdditionTest {

    @DisplayName("1,2,3을 더하면 6을 리턴한다.")
    @Test
    void adding_1_2_3_returns_6() {
        Addition ac = new Addition();
        WholeNumber actual = ac.addAll(new WholeNumbers(Arrays.asList(1,2,3)));
        WholeNumber expected = new WholeNumber(6);
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("6을 넣으면 6을을 리턴한다.")
    @Test
    void adding_6_returns_6() {
        Addition ac = new Addition();
        WholeNumber actual = ac.addAll(new WholeNumbers(Collections.singletonList(6)));
        WholeNumber expected = new WholeNumber(6);
        assertThat(actual).isEqualTo(expected);
    }
}
