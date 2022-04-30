package lotto;

import lotto.dto.ExtractLottoNumbers;
import lotto.model.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 당첨번호를 추춣해주는 클래스 테스트")
public class ExtractLottoNumbersTest {

    public static final Set<LottoNumber> LOTTO_NUMBERS = ExtractLottoNumbers.split("1, 2, 3, 4, 5, 6");

    @Test
    @DisplayName("로또 당첨번호 문자가 null일 경우 NullPointerException이 발생한다.")
    void nullTest() {
        assertThatThrownBy(() -> ExtractLottoNumbers.split(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("로또 당첨번호 입력 형식이 올바르지 않은 경우 예외가 발생한다.")
    void stringFormatFailTest() {
        assertThatThrownBy(() -> ExtractLottoNumbers.split("1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력이 올바르지 않습니다.");
    }

    @Test
    @DisplayName("로또 당첨번호를 입력하면 로또 번호 Set을  반환해준다.")
    void winnerLottoTest() {
        Set<LottoNumber> lottoNumbers = ExtractLottoNumbers.split("1, 2, 3, 3");

        // then
        assertThat(lottoNumbers).hasSize(3);
    }
}
