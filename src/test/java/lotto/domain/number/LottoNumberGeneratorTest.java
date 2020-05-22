package lotto.domain.number;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberGeneratorTest {

    @DisplayName("임의의 로또 번호 6개를 가져온다.")
    @Test
    void generateLottoNumbers() {
        List<LottoNumber> lottoNumbers = LottoNumberGenerator.generateLottoNumbers();

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @DisplayName("숫자로 로또 번호를 가져온다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 45})
    void findByNumber(int number) {
        LottoNumber lottoNumber = LottoNumberGenerator.findByNumber(number);

        assertThat(lottoNumber.getNumber()).isEqualTo(number);
    }

    @DisplayName("1 ~ 45 사이의 번호가 아닐 경우 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 47})
    void findByWrongNumberThrowException(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumberGenerator.findByNumber(number))
                .withMessage("1 ~ 45 사이의 값이 아닙니다.");
    }
}