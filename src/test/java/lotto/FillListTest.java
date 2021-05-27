package lotto;

import lotto.function.FillList;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FillListTest {

    @Test
    void apply() {
        // given
        FillList<Integer> fillResultList = new FillList<>();

        // when
        List<Integer> integers = fillResultList.apply(5, this::generateOne);

        // then
        assertThat(integers).isEqualTo(Arrays.asList(1, 1, 1, 1, 1));
    }

    private int generateOne() {
        return 1;
    }
}
