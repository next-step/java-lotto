package lotto.domain.lotto;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class NumbersTest {

    @Test
    public void 넘버_포함_여부() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Numbers numbers = new Numbers(list);

        assertTrue(numbers.contains(3));
    }

    @Test
    public void 넘버_포함_수_카운트() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Numbers numbers = new Numbers(list);
        list = Arrays.asList(4, 5, 6, 7, 8, 9);
        Numbers taegetNumbers = new Numbers(list);

        assertThat(numbers.matchCount(taegetNumbers)).isEqualTo(3);
    }
}
