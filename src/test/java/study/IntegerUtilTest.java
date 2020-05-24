package study;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class IntegerUtilTest {

    @Test
    void parseInt() {
        String[] strings = new String[]{"1", "2", "3"};
        List<Integer> integers = IntegerUtil.parseArray(strings);
        assertThat(integers).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void parseInt_throwNumberFormatException() {
        String[] strings = {"1", "2", "a"};
        assertThatThrownBy(() -> IntegerUtil.parseArray(strings))
                .isInstanceOf(NumberFormatException.class);
    }
}
