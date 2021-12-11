package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("다수의 `LottoNumber`를 구성하는 로또 번호 `LottoNumbers`에 대한 테스트")
class LottoNumbersTest {

    @DisplayName("랜덤 `LottoNumbers` 생성")
    @Test
    void createRandomLottoNumbersTest() {
        // when
        LottoNumbers randomLottoNumbers = new LottoNumbers();
        // then
        assertAll(
                () -> assertThat(randomLottoNumbers).isNotNull(),
                () -> assertThat(randomLottoNumbers.getNumbers()).hasSize(LottoNumbers.TOTAL_SIZE_OF_NUMBERS)
        );
    }

    @DisplayName("커스텀 `LottoNumbers` 생성")
    @Test
    void createCustomLottoNumbersTest() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // when
        LottoNumbers customLottoNumbers = new LottoNumbers(lottoNumbers);
        // then
        assertAll(
                () -> assertThat(customLottoNumbers).isNotNull(),
                () -> assertThat(customLottoNumbers.getNumbers()).hasSize(LottoNumbers.TOTAL_SIZE_OF_NUMBERS)
        );
    }

    @DisplayName("커스텀 `LottoNumbers` 생성 시, 잘못된 숫자로 예외 발생 확인")
    @Test
    void checkExceptionWithInvalidLottoNumbersTest() {
        // given
        List<Integer> invalidLottoNumbers = Arrays.asList(1, 2, 3, 4, 5);
        // when
        assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoNumbers(invalidLottoNumbers)
        );
    }
}
