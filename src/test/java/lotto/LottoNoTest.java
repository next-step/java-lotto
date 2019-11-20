package lotto;

import lotto.domain.LottoNo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

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

    @Test
    void validateLottoNoTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoNo lottoNo = new LottoNo(0);
            LottoNo lottoNo2 = new LottoNo(55);
        });
    }
}
