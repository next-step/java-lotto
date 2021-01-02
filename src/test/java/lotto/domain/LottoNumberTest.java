package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    private LottoNumber lottoNumber;

    @BeforeEach
    void setUp() {
        lottoNumber = new LottoNumber();
    }

    @Test
    void numberRange() {
        assertThat(lottoNumber.numberRangeSize()).isEqualTo(45);
    }
}
