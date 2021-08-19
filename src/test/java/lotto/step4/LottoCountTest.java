package lotto.step4;

import lotto.step4.domain.LottoCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoCountTest {

    @Test
    @DisplayName("수동으로 구매할 로또 수에 음수가 올 수 없다.")
    void create() {
        assertThatThrownBy(() -> new LottoCount(-1)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 금액보다 많은 로또 수를 입력 했을 때 예외가 발생한다.")
    void createAutoCount() {
        LottoCount lottoCount = new LottoCount(5);
        assertThatThrownBy(()->lottoCount.createAutoCount(3000)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입 굼액에서 수동 로또 수를 제외한 자동 로또 수가 몇개 인지 확인")
    void createAutoCount2() {
        LottoCount lottoCount = new LottoCount(5);
        assertThat(lottoCount.createAutoCount(8000)).isEqualTo(3);
    }

}
