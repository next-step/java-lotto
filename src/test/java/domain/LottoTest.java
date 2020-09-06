package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {

    @DisplayName("empty test")
    @Test
    void validateEmptyTest2() {
        assertThatThrownBy(() -> new Lotto(new HashSet<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("empty");
    }

    @DisplayName("로또 사이즈 테스트")
    @Test
    void validateSizeTest() {
        assertThatThrownBy(() -> new Lotto(new HashSet<>(Arrays
                .asList(new LottoNo(1)
                        , new LottoNo(2)
                        , new LottoNo(3)
                        , new LottoNo(4)
                        , new LottoNo(5)))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not 6");
    }

    @DisplayName("45이상 값 테스트")
    @Test
    void validateNumberRangeTest() {
        assertThatThrownBy(() -> new Lotto(new HashSet<>(Arrays
                .asList(new LottoNo(1)
                        , new LottoNo(2)
                        , new LottoNo(3)
                        , new LottoNo(4)
                        , new LottoNo(5)
                        , new LottoNo(55)))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("45");
    }
}
