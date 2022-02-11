package lotto.domain.lottonumber;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @DisplayName("넘겨준 값에 해당하는 로또 번호 객체를 반환한다.")
    @Test
    void When_정상_보너스_번호_Then_값에_해당하는_로또_번호_객체_반환() {
        LottoNumber lottoNumber = LottoNumber.from(7);
        assertThat(lottoNumber.getValue()).isEqualTo(7);
    }
}
