package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @DisplayName("LottoNumbers는 입력한 숫자들과 동일한 리스트를 가지고 있음.")
    @Test
    void lotto_number_generate_test() {
        LottoNumbers lottoNumbers = new LottoNumbers(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("6개가 동일한 숫자면 1등이다.")
    @Test
    void check_first_rank() {
        LottoNumbers lottoNumbers = new LottoNumbers(() -> Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(
            lottoNumbers.checkRank(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(
            LottoRank.FIRST);
    }
}
