package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringLottoNumbersTest {

    @Test
    @DisplayName("숫자로 구성된 문자열로 로또를 생성한다")
    void toLotto() {
        Lotto lotto = StringLottoNumbers.toLotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isNotNull();
    }
}