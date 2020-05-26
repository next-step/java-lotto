package lotto.domain.number;

import lotto.domain.number.LottoNumber;
import lotto.domain.number.LottoNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    @DisplayName("입력받은 Integer List가 중복값이 있으면 IllegalArgumentException throw")
    @Test
    void duplicatedNumbersThrowException() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumberGenerator.findAllByNumbers(numbers))
                .withMessage("번호는 중복될 수 없습니다.");
    }

    @DisplayName("입력받은 Integer List의 크기가 6이 아니면 IllegalArgumentException throw")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 7, 8})
    void notCorrectNumberSizeThrowException(int size) {
        List<Integer> numbers = IntStream.rangeClosed(1, size)
                .boxed()
                .collect(Collectors.toList());

        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumberGenerator.findAllByNumbers(numbers))
                .withMessage("번호의 갯수가 6이 아닙니다.");
    }
}
