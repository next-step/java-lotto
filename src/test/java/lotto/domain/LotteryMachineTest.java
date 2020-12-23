package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryMachineTest {

    @Test
    @DisplayName("구입 금액으로 살 수 있는 로또 갯수 계산")
    void calculateLottoCount() {
        int lottoCount = LotteryMachine.calculateLottoCount(14_000);
        assertThat(lottoCount).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 갯수만큼 로또 자동 생산")
    void issueAutomaticLotto() {
        int lottoCount = 14;
        Lottos actual = LotteryMachine.issueAutomaticLotto(lottoCount);
        assertThat(actual.getLottoListSize()).isEqualTo(lottoCount);
    }

}
