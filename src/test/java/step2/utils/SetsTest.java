package step2.utils;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetsTest {
    @Test
    void staticFactoryMethod() {
        assertThat(Sets.of(1, 2, 3, 4)) //
                .isInstanceOf(Set.class) //
                .containsExactly(1, 2, 3, 4);
    }

}
