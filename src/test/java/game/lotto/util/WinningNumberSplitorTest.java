package game.lotto.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberSplitorTest {

    @Test
    public void 콤마사이_뒤에만_공백_있을때() {
        final String stringNumbers = "1, 2, 3, 4";
        final String[] expected = {"1", "2", "3", "4"};

        String[] split = WinningNumberSplitor.split(stringNumbers);

        assertThat(split).isEqualTo(expected);
    }

    @Test
    public void 콤마사이_앞뒤로_공백_있을때() {
        final String stringNumbers = "1 , 2 , 3 , 4";
        final String[] expected = {"1", "2", "3", "4"};

        String[] split = WinningNumberSplitor.split(stringNumbers);

        assertThat(split).isEqualTo(expected);
    }

    @Test
    public void 콤마사이_공백_없을때() {
        final String stringNumbers = "1,2,3,4";
        final String[] expected = {"1", "2", "3", "4"};

        String[] split = WinningNumberSplitor.split(stringNumbers);

        assertThat(split).isEqualTo(expected);
    }
}