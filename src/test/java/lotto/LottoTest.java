package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("숫자 6개가 담긴 Lotto 객체를 생성한다.")
    void shouldCreate() {
        LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
        ));

        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto.lottoNumbers()).isEqualTo(lottoNumbers);
    }
}