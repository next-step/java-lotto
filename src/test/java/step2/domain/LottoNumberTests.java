package step2.domain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LottoNumberTests {

    @Test
    @DisplayName("LottoNumber 생성 확인")
    void lottoNumberCreate() {
        // given
        List<Integer> validNumbers = Arrays.asList(1, 3, 5, 7, 9, 11);

        // when
        LottoNumber lottoNumber = new LottoNumber(validNumbers);

        // then
        assertThat(lottoNumber.getNumbers()).isEqualTo(validNumbers);
    }

    @Test
    @DisplayName("LottoNumber invalidCount 확인")
    void lottoNumberCreate_invalidCount() {
        // given
        List<Integer> invalidNumbers = Arrays.asList(1, 3, 5, 7, 9);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new LottoNumber(invalidNumbers);
        });
        assertThat(exception.getMessage()).isEqualTo("로또 번호는 6개의 숫자로 구성되어야 합니다.");
    }

    @Test
    @DisplayName("LottoNumber invalidNumber 확인")
    void lottoNumberCreate_invalidNumber() {
        // given
        List<Integer> invalidNumbers = Arrays.asList(1, 3, 5, 7, 9, 50);

        // when & then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new LottoNumber(invalidNumbers);
        });
        assertThat(exception.getMessage()).isEqualTo("로또 번호는 1부터 45까지의 정수 중 하나여야 합니다.");
    }
}
