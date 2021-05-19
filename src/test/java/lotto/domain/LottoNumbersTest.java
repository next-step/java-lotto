package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @Test
    @DisplayName("로또번호가 중복이거나 입력이 추가/부족 일 경우(6자리가 아닐경우) 예외발생")
    void checkLottoNumbersSize() {
        assertThatThrownBy(()-> new LottoNumbers(1,2,3,4,5,5))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("로또 번호는 6자리여야 합니다.");
    }

    @Test
    @DisplayName("숫자값 일치하는 갯수 테스트")
    void matchNumbers() {
        LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);

        int matchCount = lottoNumbers.matchNumbers(new LottoNumbers(1, 2, 3, 4, 5, 7));

        Assertions.assertThat(matchCount).isEqualTo(5);
    }
}
