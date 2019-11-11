package lotto;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    @Test
    @DisplayName("기본 로또번호 45개를 만드는지 확인한다.")
    void defaultNumbers() {
        LottoNumbers lottoNumbers = LottoNumbers.defaultNumbers();
        assertThat(lottoNumbers.size()).isEqualTo(45);
    }

    @Test
    @DisplayName("subNumbers로 나온 size를 확인한다.")
    void subNumbers() {
        int fromIndex = 0;
        int toIndex = 6;
        int expectedSize = toIndex - fromIndex;
        LottoNumbers lottoNumbers = LottoNumbers.defaultNumbers();

        LottoNumbers subNumbers = lottoNumbers.subNumbers(fromIndex, toIndex);

        assertThat(subNumbers.size()).isEqualTo(expectedSize);
    }

    @Test
    @DisplayName("숫자 문자열을 입력받아 LottoNumbers를 생성한다.")
    void ofString() {
        String numberString = "1, 2, 3, 4, 5, 6";
        LottoNumbers lottoNumbers = LottoNumbers.of(numberString);

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("숫자 문자열 중 중복이 있을시 에러 확인")
    void checkDuplicated() {
        String numberString = "1, 2, 2, 4, 5, 6";
        assertThatThrownBy(() -> {
            LottoNumbers lottoNumbers = LottoNumbers.of(numberString);
        }).hasMessage(LottoNumbers.DUPLICATED_NUMBER_ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 문자열 길이가 6이 넘어가면 에러 확인")
    void checkLottoLength() {
        String numberString = "1, 2, 3, 4, 7, 5, 6";
        assertThatThrownBy(() -> {
            LottoNumbers lottoNumbers = LottoNumbers.of(numberString);
        }).hasMessage(LottoNumbers.OUT_OF_RANGE_ERROR_MESSAGE)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
