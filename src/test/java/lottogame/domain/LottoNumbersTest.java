package lottogame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {

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
