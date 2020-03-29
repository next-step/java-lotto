package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberTest {

    @DisplayName("로또 숫자를 랜덤하게 중복없이 6개 추출한다.")
    @Test
    void canCreateLottoNumbers() {
        LottoNumber lottoNumber = new LottoNumber();
        assertThat(lottoNumber.getLottoNumbers().size()).isSameAs(6);
    }

}
