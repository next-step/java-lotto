package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumbersFactoryTest {

    @DisplayName("로또 번호 객체를 생성할 수 있다.")
    @Test
    void canCreateAutoLottoNumbers() {
        assertThat(LottoNumbersFactory.createAutoLottoNumbers()).isNotNull();
    }

    @DisplayName("수동 번호로 객체를 생성할 수 있다.")
    @Test
    void canCreateManualLottoNumbers() {
        String manualNumbers = "1, 2, 3, 4, 5, 6";
        assertThat(LottoNumbersFactory.createManualLottoNumbers(manualNumbers)).isNotNull();
    }
}
