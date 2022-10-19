package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호가 6자리가 아닌 경우 예외 발생")
    void 로또_5자리_확인() {
        List<LottoNumber> lengthTest = List.of(new LottoNumber(1),
                new LottoNumber(3),
                new LottoNumber(5),
                new LottoNumber(7),
                new LottoNumber(9));
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(
                lengthTest));
    }

    @Test
    @DisplayName("로또 번호가 6자리가 아닌 경우 예외 발생")
    void 로또_7자리_확인() {
        List<LottoNumber> lengthTest = List.of(new LottoNumber(1),
                new LottoNumber(3),
                new LottoNumber(5),
                new LottoNumber(7),
                new LottoNumber(9),
                new LottoNumber(22),
                new LottoNumber(25)
        );
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumbers(
                lengthTest));
    }
}