package lotto.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ConvertUtilTest {

    @Test
    @DisplayName("정수로 변환")
    public void toInt() throws Exception {
        assertThat(ConvertUtil.toInt("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("정수 리스트로 변환")
    public void toIntegers() throws Exception {
        List<Integer> integers = Arrays.asList(1, 2, 3);
        assertThat(ConvertUtil.toIntegers(Arrays.asList("1", "2", "3"))).isEqualTo(integers);
    }
}
