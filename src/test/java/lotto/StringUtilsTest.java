package lotto;

import lotto.utils.StringUtils;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class StringUtilsTest {
    @Test
    void split() {
        // GIVE
        String[] array = StringUtils.split("1,2,3,4,5,6");
        // WHEN
        // THAT
        assertThat(array.length).isEqualTo(6);

    }
}
