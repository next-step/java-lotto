package camp.nextstep.edu.nextstep8.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class StringLottoNumberConvertorTest {
    @DisplayName("로또 문자 열이 잘 변환 되는지 확인")
    @Test
    public void convertTest() {
        // given
        String lottoNumberStr = "1,2,3,4,5,6";

        // when
        List<Integer> lottoNumbers = StringLottoNumberConvertor.convert(lottoNumberStr);

        // then
        assertAll(
                () -> assertThat(lottoNumbers.size()).isEqualTo(6),
                () -> assertThat(lottoNumbers.get(0)).isEqualTo(1),
                () -> assertThat(lottoNumbers.get(1)).isEqualTo(2),
                () -> assertThat(lottoNumbers.get(2)).isEqualTo(3),
                () -> assertThat(lottoNumbers.get(3)).isEqualTo(4),
                () -> assertThat(lottoNumbers.get(4)).isEqualTo(5),
                () -> assertThat(lottoNumbers.get(5)).isEqualTo(6)
        );
    }

    @DisplayName("빈 문자열 일 경우 예외")
    @Test
    public void validateEmptyTest() {
        // when & then
        assertThatThrownBy(() -> StringLottoNumberConvertor.convert(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("번호가 없습니다");
    }

    @DisplayName("번호가 중복 되었거나 6개가 아닌 경우 예외")
    @Test
    public void validateCountTest() {
        // given
        String lottoNumberStr = "1,2,3,4,5,5";

        // when & then
        assertThatThrownBy(() -> StringLottoNumberConvertor.convert(lottoNumberStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("번호의 개수는 6개여야 합니다 : 5");
    }

    @DisplayName("로또 번호가 아닌 경우 예외")
    @Test
    public void validateNumberTest() {
        // given
        String lottoNumberStr ="1,2,3,4,5,46";

        // when & then
        assertThatThrownBy(() -> StringLottoNumberConvertor.convert(lottoNumberStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 번호 입니다 : 46");
    }
}
