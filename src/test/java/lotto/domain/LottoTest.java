package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    private Lotto lotto;
    @BeforeEach
    void setUp() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }
    @Test
    void lotto() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("Lotto number must be 6");
    }

    @Test
    void getSameCount() {
        int sameCount = lotto.getSameCount(new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));

        assertThat(sameCount).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true", "7:false"}, delimiter = ':')
    void contains(int value, boolean expected) {
        assertThat(lotto.contains(value)).isEqualTo(expected);
    }
}
