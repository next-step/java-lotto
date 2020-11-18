package step2.utils;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class SetsTest {
    @Test
    void staticFactoryMethod() {
        assertThat(Sets.of(1, 2, 3, 4)) //
                .isInstanceOf(Set.class) //
                .containsExactly(1, 2, 3, 4);
    }

}
