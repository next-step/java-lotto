package lotto.step2.domain.factory;

import lotto.step2.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersFactoryTest {
    
    @Test
    @DisplayName("특정 로또 번호 가져오기")
    void getInstance() {
        assertThat(new LottoNumber(3)).isEqualTo(LottoNumbersFactory.getLottoNumber(3));
    }
}