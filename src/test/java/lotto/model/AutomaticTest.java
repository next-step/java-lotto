package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AutomaticTest {

    @Test
    @DisplayName("금액에 맞게 자동으로 구매할 로또 정보를 구성한다.")
    void 자동로또_정보() {
        // given
        Automatic automatic = new Automatic(new LottoMoney(14000));

        // when
        int autoCount = automatic.getAutoCount();

        // then
        Assertions.assertThat(autoCount).isEqualTo(14);
    }
}