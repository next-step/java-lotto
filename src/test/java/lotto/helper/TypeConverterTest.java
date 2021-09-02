package lotto.helper;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TypeConverterTest {

    @DisplayName("int[][]를 List<List<Integer>>로 변환한다.")
    @Test
    void convertArrayOfIntArrayToListOfIntegerList() {
        List<List<Integer>> expected = Arrays.asList(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        List<List<Integer>> actual = TypeConverter.valueOf(new int[][]{{1, 2, 3}, {4, 5, 6}});
        assertThat(actual).isEqualTo(expected);
    }
}
