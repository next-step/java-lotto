package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.domain.LottoFixtures;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void 구매금액이_1000원_미만이면_안된다() {
        assertThatThrownBy(() -> new LottoMachine(900, LottoFixtures.FIXED_LOTTO_CREATOR))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 구매 금액이 1000원 이상이어야 합니다.");
    }

    @Test
    void 구매금액에_따른_개수만큼_로또를_생성한다() {
        LottoMachine lottoMachine = new LottoMachine(14000, LottoFixtures.FIXED_LOTTO_CREATOR);
        assertThat(lottoMachine.getLottos()).hasSize(14);
    }
}
