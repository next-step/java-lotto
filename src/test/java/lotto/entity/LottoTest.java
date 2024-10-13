package lotto.entity;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void 정렬() {
        List<Integer> numbers = Arrays.asList(10, 4, 9, 2, 5, 1);
        Lotto lotto = new Lotto(numbers);

        assertThat(lotto.getLottoNumbers()).isEqualTo(Arrays.asList(1, 2, 4, 5, 9, 10));
    }
}
