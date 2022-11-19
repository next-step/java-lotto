package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.model.LottoNumber.lottoNumberSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ManualLottoTest {

    @Test
    @DisplayName("수동로또수는 구매금액보다 적다")
    void manual() {
        assertThatThrownBy(() -> new ManualLotto(3, 2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동로또수만큼 수동로또개수를 생성한다")
    void manual_size() {
        ManualLotto manualLotto = new ManualLotto(3);
        assertThat(manualLotto.make(lottoNumberSet(1, 2, 3, 4, 5, 6)).size()).isEqualTo(3);
    }
}