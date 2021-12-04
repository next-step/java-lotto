package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("숫자 6개가 담긴 Lotto 객체를 생성한다.")
    void shouldCreateLotto() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto).isEqualTo(new Lotto(lottoNumbers));
    }

    @Test
    @DisplayName("주어진 개수만큼 당첨 번호와 일치하는지 확인한다")
    void shouldCheckWinningNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 7, 8, 9));
        Lotto lotto = new Lotto(lottoNumbers);

        boolean result = lotto.result(winningNumbers, count -> count == 3);
        assertThat(result).isTrue();
    }
}