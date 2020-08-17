package util;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitUtilTest {
    @Test
    void splitToNumber() {
        List<Integer> result = SplitUtil.splitToNumber("1,2,3,4", ",");

        assertThat(result).hasSize(4).containsExactly(1, 2, 3, 4);
    }
}
