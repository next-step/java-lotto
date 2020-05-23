package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersFactoryTest {

    @DisplayName("로또 번호 객체를 생성할 수 있다.")
    @Test
    void canCreateLottoNumbers() {
        assertThat(LottoNumbersFactory.createLottoNumbers()).isNotNull();
    }
}
