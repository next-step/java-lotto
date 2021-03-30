package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    private LottoNumber number;
    private static int TEST_NUMBER = 3;
    private static int NEGATIVE_NUMBER = -1;
    private static int OVER_NUMBER = 46;

    @BeforeEach
    void setUp() {
        number = new LottoNumber(TEST_NUMBER);
    }

    @Test
    void createNumber() {
        assertThat(number).isEqualTo(new LottoNumber(TEST_NUMBER));
    }

    @Test
    void validNumber() {
        assertThatThrownBy(() -> {
            new LottoNumber(NEGATIVE_NUMBER);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new LottoNumber(OVER_NUMBER);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
