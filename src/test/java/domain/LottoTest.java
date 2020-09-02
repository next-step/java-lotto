package domain;


import org.junit.jupiter.api.Test;
import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {


    @Test
    void validateEmptyTest2() {
        assertThatThrownBy(() -> new Lotto(new HashSet<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("empty");
    }

}
