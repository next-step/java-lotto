package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoNumbersTest {

    @DisplayName("생성자의 인자로 들어온 LottoNumbers의 size가 6이 아니면 예외 발생")
    @Test
    void notRequiredSizedLottoNumbersThrowsException() {
        // given
        List<LottoNumber> lottoNumbers = Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5)
        );

        // when & then
        assertThrows(RuntimeException.class,
                () -> new LottoNumbers(lottoNumbers));
    }
}