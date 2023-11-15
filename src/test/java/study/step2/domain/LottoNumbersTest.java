package study.step2.domain;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {

    @Test
    void 로또_숫자_범위() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        assertThat(lottoNumbers.pool()).hasSize(45);
        assertThat(lottoNumbers.pool()).contains(1);
        assertThat(lottoNumbers.pool()).contains(45);
    }

    @Test
    void add() {
        LottoNumbers lottoNumbers = new LottoNumbers();
        lottoNumbers.add(1);
        assertThat(lottoNumbers.lottoNumbers()).hasSize(1);
    }

    @Test
    void sort() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(2, 5, 6, 1, 39, 3));
        lottoNumbers.sort();
        assertThat(lottoNumbers.lottoNumbers().get(0)).isEqualTo(1);
        assertThat(lottoNumbers.lottoNumbers().get(lottoNumbers.lottoNumbers().size() - 1)).isEqualTo(39);
    }
}
