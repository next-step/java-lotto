package lotto.domain;

import lotto.domain.strategy.LottoStrategy;
import lotto.domain.strategy.TestStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    final LottoStrategy testStrategy = new TestStrategy();
    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        this.lottoMachine = new LottoMachine(10000, testStrategy);
    }

    @Test
    @DisplayName("주어진 금액으로 몇 장의 로또인지 확인")
    void numberOfLottoTickets() {
        final LottoMachine lottoMachine = new LottoMachine(10001, testStrategy);

        assertThat(lottoMachine.countNumberOfLottoTickets())
                .isEqualTo(10);
    }

    @Test
    @DisplayName("당첨 번호 입력 테스트")
    void conclusionWinningNumbers() {
        this.lottoMachine.conclusionWinningNumbers("1,2,3,4,5,6");
        assertThat(this.lottoMachine)
                .extracting("winningLotto")
                .isNotNull();
    }

//    @Test
//    @DisplayName("당첨 통계 확인")
//    void winnerStat() {
//        this.lottoMachine.conclusionWinningNumbers("1,2,3,4,5,6");
//        assertThat(this.lottoMachine.winningStat())
//                .isInstanceOf(WinningStatDto.class)
//                .extracting("firstCount")
//                .isEqualTo(1);
//    }
}
