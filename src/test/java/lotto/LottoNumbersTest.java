package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    @DisplayName("최소값 예외처리")
    void create() {
        assertThatThrownBy(() -> {
            LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값이 존재하는지 검증")
    void contains() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
        assertThat(lottoNumbers.contains(6)).isTrue();
        assertThat(lottoNumbers.contains(7)).isFalse();
    }

    @Test
    @DisplayName("정렬 및 equals ")
    void sort() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(6,5,4,3,2,1));
        lottoNumbers.sort();
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)));
    }
}