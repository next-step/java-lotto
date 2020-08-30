package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTest {
    List<Integer> lottoNumber;

    @BeforeEach
    void setUp() {
        lottoNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    void validateSizeTest() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("not 6");
    }

    @Test
    void validateEmptyTest2() {
        assertThatThrownBy(() -> new Lotto(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("empty");
    }


    @Test
    void validateDuplicateTest2() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 2, 4, 5, 6)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
