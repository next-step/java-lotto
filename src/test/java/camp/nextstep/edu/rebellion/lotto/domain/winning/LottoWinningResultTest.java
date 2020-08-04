package camp.nextstep.edu.rebellion.lotto.domain.winning;

import camp.nextstep.edu.rebellion.lotto.domain.LottoAward;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoWinningResultTest {
    List<LottoAward> awards;
    @BeforeEach
    public void setup() {
        awards = Arrays.asList(LottoAward.FIRST,
                LottoAward.SECOND,
                LottoAward.THIRD,
                LottoAward.FOURTH,
                LottoAward.LOSE
                );
    }

    @DisplayName("등 수 별 당첨된 개수를 올바르게 가져오는지 확인")
    @Test
    public void getAwardCountTest() {
        // given
        LottoWinningResult result = new LottoWinningResult(awards);

        // when & then
        assertAll(
                () -> assertThat(result.getAwardCount(LottoAward.FIRST)).isOne(),
                () -> assertThat(result.getAwardCount(LottoAward.SECOND)).isOne(),
                () -> assertThat(result.getAwardCount(LottoAward.THIRD)).isOne(),
                () -> assertThat(result.getAwardCount(LottoAward.FOURTH)).isOne()
        );
    }

    @DisplayName("총 당첨금액을 올바르게 가져오는지 확인")
    @Test
    public void getTotalPrize() {
        // given
        LottoWinningResult result = new LottoWinningResult(awards);

        // when & then
        assertThat(result.getTotalPrize()).isEqualTo(
                LottoAward.FIRST.getPrize() +
                LottoAward.SECOND.getPrize() +
                LottoAward.THIRD.getPrize() +
                LottoAward.FOURTH.getPrize()
        );
    }
}
