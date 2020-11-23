package lotto;

import lotto.model.Hit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

public class HitTest {

    @Test
    public void 맞은_개수_정상_리턴() {
        SortedSet<Integer> hit3 = new TreeSet<>(Arrays.asList(1,2,3));
        assertThat(Hit.findByNumbers(hit3,7)).isEqualTo(Hit.HIT_3);

        SortedSet<Integer> hit4 = new TreeSet<>(Arrays.asList(1,2,3,4));
        assertThat(Hit.findByNumbers(hit4,7)).isEqualTo(Hit.HIT_4);

        SortedSet<Integer> hit5 = new TreeSet<>(Arrays.asList(1,2,3,4,5));
        assertThat(Hit.findByNumbers(hit5,7)).isEqualTo(Hit.HIT_5);

        SortedSet<Integer> hit5Second = new TreeSet<>(Arrays.asList(1,2,3,4,5,7));
        assertThat(Hit.findByNumbers(hit5Second,7)).isEqualTo(Hit.HIT_6_BONUS);

        SortedSet<Integer> hit6 = new TreeSet<>(Arrays.asList(1,2,3,4,5,6));
        assertThat(Hit.findByNumbers(hit6,7)).isEqualTo(Hit.HIT_6);

        SortedSet<Integer> hitNone = new TreeSet<>(Collections.emptyList());
        assertThat(Hit.findByNumbers(hitNone,7)).isEqualTo(Hit.HIT_NONE);
    }
}
