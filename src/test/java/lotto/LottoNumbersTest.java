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
    @DisplayName("정렬 및 equals ")
    void sort() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(6,5,4,3,2,1));
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(Arrays.asList(1,2,3,4,5,6)));
    }

    @Test
    @DisplayName("입력 값이 존재하는지 검증")
    void contains() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
        assertThat(lottoNumbers.contains(new LottoNumber(6))).isTrue();
        assertThat(lottoNumbers.contains(new LottoNumber(7))).isFalse();
    }

    @Test
    @DisplayName("로또번호와 로또를 비교하여 몇개의 숫자가 맞는지 반환")
    void match() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,8));

        int match = lottoNumbers.match(lotto);

        assertThat(match).isEqualTo(5);
    }
}