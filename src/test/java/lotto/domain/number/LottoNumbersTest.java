package lotto.domain.number;

import lotto.domain.lotto.LottoNumberGenerator;
import lotto.domain.lotto.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("LottoNumbers 클래스 테스트")
public class LottoNumbersTest {
    @DisplayName("LottoNumbers 객체를 생성할 수 있다.")
    @Test
    void createLottoNumbers() {
        LottoNumbers lottoNumbers = LottoNumbers.autoLottoNumber(
                new LottoNumberGenerator(new Price(1000), Collections.emptyList()).getAutoLottoNumbers()
        );

        assertThat(lottoNumbers.getNumbers()).hasSize(LottoNumbers.LOTTO_SIZE);
    }

    @DisplayName("6자리인지 검증할 수 있다.")
    @Test
    void validateLottoNumbersLength() {
        assertThatExceptionOfType(LottoNumbersLengthException.class)
                .isThrownBy(() -> LottoNumbers.manualLottoNumber(Arrays.asList(1, 2, 3, 4, 5)))
                .withMessage(LottoNumbersLengthException.MESSAGE);
    }

    @DisplayName("중복된 값이 있는지 검증할 수 있다.")
    @Test
    void validateLottoNumberDuplicate() {
        assertThatExceptionOfType(LottoNumbersDuplicateException.class)
                .isThrownBy(() -> LottoNumbers.manualLottoNumber(Arrays.asList(1, 2, 2, 3, 4, 5)))
                .withMessage(LottoNumbersDuplicateException.MESSAGE);
    }

    @DisplayName("LottoNumber와 비교하여 존재하는 갯수를 리턴할 수 있다.")
    @Test
    void matchCount() {
        LottoNumber bonusLottoNumber = new LottoNumber(1);
        LottoNumbers lottoNumbers = LottoNumbers.manualLottoNumber(Arrays.asList(1, 2, 3, 4, 5, 6));

        int actual = lottoNumbers.matchCount(bonusLottoNumber);

        assertThat(actual).isEqualTo(1);
    }
}
