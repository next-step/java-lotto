package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersTest {

    LottoNumbers lottoNumbers;

    @Test
    @DisplayName("정답 로또 생성")
    void winningNumbers() {
        String winningNumbers = "1, 2, 3, 4, 5, 6";

        lottoNumbers = new LottoNumbers();
        LottoNumbers winningLotto = lottoNumbers.createWinningNumbers(winningNumbers);

        assertThat(winningLotto.getNumbers()).isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

}
