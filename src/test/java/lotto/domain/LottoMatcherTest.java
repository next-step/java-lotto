package lotto.domain;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatcherTest {
    @Test
    public void 로또3개_일치() {
        List<Integer> userLotto = Arrays.asList(1,2,3,4,5,6);
        List<Integer> winningLotto = Arrays.asList(1,2,3,7,8,9);

        final int[] count = {0};
        userLotto.stream().forEach(num -> {
            if (winningLotto.contains(num)) {
                count[0] += 1;
            }
        });
        assertThat(count[0]).isEqualTo(3);
    }
}
