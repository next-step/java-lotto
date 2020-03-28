package lotto.domain;

import lotto.exception.OutOfLottoNumberSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNumbersTest {
    @DisplayName("LottoNumbers 객체 생성을 할 수 있다.")
    @Test
    void create() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.valueOf(1)
                , LottoNumber.valueOf(2)
                , LottoNumber.valueOf(3)
                , LottoNumber.valueOf(4)
                , LottoNumber.valueOf(5)
                , LottoNumber.valueOf(6)
        );

        LottoNumbers expect = new LottoNumbers(lottoNumbers);

        LottoNumbers actual = new LottoNumbers(lottoNumbers);

        assertThat(actual).isEqualTo(expect);
    }

    @DisplayName("로또 번호 갯수가 6개가 아니라면 예외를 발생한다.")
    @Test
    void checkLottoNumberSizeSix() {
        List<LottoNumber> lottoNumbers = Arrays.asList(
                LottoNumber.valueOf(1)
                , LottoNumber.valueOf(2)
                , LottoNumber.valueOf(3)
                , LottoNumber.valueOf(4)
                , LottoNumber.valueOf(5)
                , LottoNumber.valueOf(6)
                , LottoNumber.valueOf(7)
        );

        assertThatExceptionOfType(OutOfLottoNumberSizeException.class).isThrownBy(
                () -> new LottoNumbers(lottoNumbers)
        );
    }

    @DisplayName("입력받은 당첨 번호 문자열을 Lottery 객체로 생성할 수 있다.")
    @Test
    void createFromInput() {
        final String input = "1, 2, 3, 4, 5, 6";
        LottoNumbers expect = new LottoNumbers(input);

        LottoNumbers actual = new LottoNumbers(input);

        assertThat(actual).isEqualTo(expect);
    }
}