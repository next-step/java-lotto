package util;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ParsingUtilTest {
    @Test
    public void String_으로_입력받은_값을_int_리스트로_파싱한다() {
        List<Integer> result = ParsingUtil.parseStringToIntList("1, 2, 3, 4,5,6");

        assertThat(result).hasSize(6).containsExactly(1, 2, 3, 4, 5, 6);
    }
}