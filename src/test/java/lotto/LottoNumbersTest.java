package lotto;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    void create() {
        assertThatThrownBy(() -> {
            LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void contains() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
        assertThat(lottoNumbers.contains(6)).isTrue();
        assertThat(lottoNumbers.contains(7)).isFalse();
    }

    @Test
    void sort() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(6,5,4,3,2,1));
        lottoNumbers.sort();
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)));
    }
}