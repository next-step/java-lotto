package lotto;

import lotto.domain.LottoNo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNoTest {

    private LottoNo lottoNo;

    @BeforeEach
    void setUp() {
        lottoNo = new LottoNo(5);
    }

    @Test
    void constructorTest() {
        assertThat(lottoNo).isEqualTo(new LottoNo(5));
    }
}
