package domain;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    @Test
    void validateEmptyTest2() {
        assertThatThrownBy(() -> new Lotto(new HashSet<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("empty");
    }

    @Test
    void validateEmptyTest() {
        assertThatThrownBy(() -> new Lotto(new HashSet<>(Arrays.asList(1,2,3,4,5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not 6");
    }

}
