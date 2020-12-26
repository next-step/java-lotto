package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryMachineTest {

    @Test
    @DisplayName("구입 금액으로 살 수 있는 로또 갯수 계산")
    void calculateLottoCount() {
        LottoCount lottoCount = LotteryMachine.calculateLottoCount(14500);
        assertThat(lottoCount).isEqualTo(new LottoCount(14));
    }

    @Test
    @DisplayName("자동 로또 갯수 계산")
    void calculateAutomaticLottoCount() {
        LottoCount lottoCount = new LottoCount(14);
        LottoCount automaticLottoCount = LotteryMachine.calculateAutomaticLottoCount(lottoCount, 3);
        assertThat(automaticLottoCount).isEqualTo(new LottoCount(11));
    }

    @Test
    @DisplayName("로또 갯수만큼 로또 자동 생산")
    void issueAutomaticLotto() {
        LottoCount lottoCount = new LottoCount(14);
        Lottos actual = LotteryMachine.issueAutomaticLotto(lottoCount);
        assertThat(actual.getLottoListSize()).isEqualTo(14);
    }

}
