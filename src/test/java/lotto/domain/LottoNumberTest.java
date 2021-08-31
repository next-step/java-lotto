package lotto.domain;

import lotto.exception.InvalidNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoNumberTest {
    private LottoNumber lottoNumber;

    @DisplayName("1 ~ 45 범위의 로또 숫자 객체를 총 45개 생성할 수 있다.")
    @Test
    void createLottoNumber() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = LottoNumber.MIN_NUMBER; i <= LottoNumber.MAX_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }

        int actual = 45;
        assertEquals(actual, lottoNumbers.size());
    }

    @DisplayName("1 ~ 45 범위 외 로또 숫자는 예외가 발생한다.")
    @Test
    void checkLottoNumberException() {
        int invalidNumber = 46;
        assertThatExceptionOfType(InvalidNumberException.class).isThrownBy(
                () -> new LottoNumber(invalidNumber));
    }
}
