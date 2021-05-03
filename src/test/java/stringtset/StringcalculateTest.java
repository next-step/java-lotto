package stringtset;

import StringCalculator.StringCalculator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringcalculateTest {
    StringCalculator stringCalculator = new StringCalculator();

    @Test
    void split() {
        String str = "1,2:3:4";
        assertThat(stringCalculator.split(str)).containsExactly(1, 2, 3, 4);
    }

    @Test
    void split2() {
        String str = "//;\n1,2:3;4";
        assertThat(stringCalculator.split(str)).containsExactly(1, 2, 3, 4);
    }

    @Test
    void add() {
        List<Integer> strcharList = Arrays.asList(1, 2, 3);
        assertThat(stringCalculator.add(strcharList)).isEqualTo(6);
    }
}
