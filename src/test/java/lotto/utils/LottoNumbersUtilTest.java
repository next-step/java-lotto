package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lotto.domain.LottoNumbers;

/**
 * LottoNumbersUtil의 기능 테스트
 */
public class LottoNumbersUtilTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3,4,5,6", "a,b,c,d,e,f"})
    @DisplayName("문자열을 로또번호로 변활할 떄 유효성 검사")
    void validate_toLottoNumbers(String textNumber) {
        assertThatThrownBy(() -> LottoNumbersUtil.toLottoNumbers(textNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "5,3,1,7,9,10", "10,37,2,45,7,28"})
    @DisplayName("같은 문자열의 숫자목록으로 만들어진 로또번호목록들이 서로 같은지 확인")
    void toLottoNumbers(String textNumber) {
        // given
        LottoNumbers lottoNumbers = LottoNumbersUtil.toLottoNumbers(textNumber);
        LottoNumbers targetLottoNumbers = LottoNumbersUtil.toLottoNumbers(textNumber);

        // then
        assertThat(lottoNumbers).isEqualTo(targetLottoNumbers);
    }
}
