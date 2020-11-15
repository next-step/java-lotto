package domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private Lotto lotto = new Lotto(Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList()));

    @Test
    void countMatchingTest() {
        List<Integer> winningNumbers = Arrays.stream(new int[]{1, 2, 3, 4, 5, 6}).boxed().collect(Collectors.toList());
        assertThat(lotto.countMatching(winningNumbers)).isEqualTo(6L);
    }
}
