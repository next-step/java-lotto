package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    @Test
    public void testLottoNumberCreate() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers.getLottoNumbers().size()).isSameAs(6);
    }
}
