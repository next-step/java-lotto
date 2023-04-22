package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class CollectionsTest {

    @Test
    void 셔플() {
        List<Integer> numbers = new ArrayList<>(){{
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
                add(6);
        }};
        List<Integer> original = new ArrayList<>(numbers);
        Collections.shuffle(numbers);
        assertAll(
            () -> assertThat(numbers).hasSize(original.size()),
            () -> assertThat(Set.copyOf(numbers)).isEqualTo(Set.copyOf(original))
        );
    }

}
