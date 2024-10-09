package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoNumbersTest {

    @DisplayName("로또 번호들이 정렬된다.")
    @Test
    void create() {
        List<LottoNumber> numbers = Arrays.asList(
                new LottoNumber(5),
                new LottoNumber(1),
                new LottoNumber(3),
                new LottoNumber(2),
                new LottoNumber(4),
                new LottoNumber(6)
        );

        LottoNumbers lottoNumbers = new LottoNumbers(numbers);

        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertEquals(expected, lottoNumbers.getLottoNumbers());
    }

    @DisplayName("중복된 로또 번호가 있을 경우 예외가 발생한다.")
    @Test
    void throwExceptionForDuplicationNumber() {
        List<LottoNumber> numbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(1),
                new LottoNumber(3),
                new LottoNumber(2),
                new LottoNumber(4),
                new LottoNumber(6)
        );

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(numbers);
        });
    }

}