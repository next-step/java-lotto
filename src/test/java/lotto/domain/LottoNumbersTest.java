package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumbersTest {

    @Test
    public void lottoNumbersCreateTest() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers.lottoNumbersCount()).isEqualTo(45);
    }

    @Test
    public void generateShuffleNumberTest() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers.generateShuffleNumber().size()).isEqualTo(6);
    }
}