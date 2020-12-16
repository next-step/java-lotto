package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void autoGenerateLottoNumberTest() {
        assertThat(Lotto.from().getLottoNumbers()).hasSize(6);
    }

}
