package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
}