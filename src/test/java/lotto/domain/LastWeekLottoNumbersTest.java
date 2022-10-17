package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LastWeekLottoNumbersTest {
    @Test
    @DisplayName("로또 번호가 6자리가 아닌 경우 예외 발생")
    void 로또_6자리_확인() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                LastWeekLottoNumbers.createLottoNumbers(new String[]{"1","3","4","5"}));
        assertThatIllegalArgumentException().isThrownBy(() ->
                LastWeekLottoNumbers.createLottoNumbers(new String[]{"1","3","4","5","6","7"}));
    }

    @Test
    @DisplayName("로또 번호가 1보다 작거나, 45보다 크면 예외 발생")
    void 로또_번호_확인() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                LastWeekLottoNumbers.createLottoNumbers(new String[]{"45","48","7","1","3"}));
        assertThatIllegalArgumentException().isThrownBy(() ->
                LastWeekLottoNumbers.createLottoNumbers(new String[]{"0","4","7","1","3"}));
    }

    @Test
    @DisplayName("정상 로또 번호 입력 시 List<Integer> 로 변환 확인")
    void 로또_String_to_Integer() {
       assertThat(LastWeekLottoNumbers
               .createLottoNumbers(new String[]{"1","45","3","8","12","42"})
               .getLottoNumbers())
               .isEqualTo(List.of(1, 45, 3, 8, 12, 42));
    }
}