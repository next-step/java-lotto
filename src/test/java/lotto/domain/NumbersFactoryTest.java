package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumbersFactoryTest {

    @DisplayName("로또 번호를 만들 수 있다.")
    @Test
    void canCreateLottoNumbers() {
        assertThat(NumbersFactory.createLottoNumbers()).isNotNull();
    }
}
