package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    @DisplayName("숫자값 일치하는 갯수 테스트")
    void matchNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);

        int matchCount = lottoNumbers.matchNumbers(new LottoNumbers(1, 2, 3, 4, 5, 7));

        Assertions.assertThat(matchCount).isEqualTo(5);
    }
}
