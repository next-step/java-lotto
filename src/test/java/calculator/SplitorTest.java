package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitorTest {

    @Test(expected = IllegalArgumentException.class)
    public void 빈문자열_입력() {
        final String emptyString = "";

        Splitor.split(emptyString);
    }

    @Test(expected = IllegalArgumentException.class)
    public void null입력() {
        final String nullString = null;

        Splitor.split(nullString);
    }

    @Test
    public void 콤마_구분자() {
        final String expression = "1,2,3";
        final String[] expected = {"1", "2", "3"};

        final String[] actual = Splitor.split(expression);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 콜론_구분자() {
        final String expression = "1:2:3:4";
        final String[] expected = {"1", "2", "3", "4"};

        final String[] actual = Splitor.split(expression);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void 커스텀_구분자() {
        final String expression = "//?\n2?3?4";
        final String[] expected = {"2", "3", "4"};

        final String[] actual = Splitor.split(expression);

        assertThat(actual).isEqualTo(expected);
    }

}