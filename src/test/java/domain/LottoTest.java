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
        assertThatThrownBy(() -> new Lotto(new HashSet<>(Arrays
                .asList(new LottoNo(1)
                        ,new LottoNo(2)
                        ,new LottoNo(3)
                        ,new LottoNo(4)
                        ,new LottoNo(5)
                        ,new LottoNo(6)))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not 6");
    }

}
