package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {
    @Test
    @DisplayName("주어진 숫자로 로또 번호를 생성한다")
    void shouldCreateLottoNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName("주어진 개수만큼 당첨 번호와 일치하는지 확인한다")
    void shouldCheckWinningNumbers() {
        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9));

        assertThat(lottoNumbers.result(winningNumbers, count -> count == 3)).isTrue();
    }
}