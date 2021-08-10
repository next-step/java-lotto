package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoNumberFactoryTest {

    @DisplayName("번호를 넘겼을때 해당하는 LottoNumber객체를 반환")
    @Test
    void getLottoNumber_넘긴_번호에_해당하는_LottoNumber_반환() {
        assertThat(LottoNumberFactory.getLottoNumber(5)).isEqualTo(new LottoNumber(5));
    }

}
