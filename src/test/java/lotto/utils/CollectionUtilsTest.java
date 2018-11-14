package lotto.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CollectionUtilsTest {

    @Test
    public void 문자배열을_숫자리스트로_변환할수있다() {
        String[] texts = new String[] { "1", "2", "3", "4", "5", "6" };
        List<Integer> result = CollectionUtils.convert(texts);
        assertThat(result).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void 숫자리스트와_숫자를_병합할수있다() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = CollectionUtils.merge(numbers, 6);
        assertThat(result).contains(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void 숫자리스트와_여러숫자를_병합할수있다() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = CollectionUtils.merge(numbers, 6, 7);
        assertThat(result).contains(1, 2, 3, 4, 5, 6, 7);
    }
}