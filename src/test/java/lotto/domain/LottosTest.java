package lotto.domain;

import lotto.strategy.LottoStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.fixture.LottosFixture.로또_티켓별_번호;
import static lotto.domain.fixture.LottosFixture.자동_로또;
import static lotto.domain.fixture.WinningLottoFixture.지난주_로또_당첨;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

class LottosTest {

    private Lottos lottos;

    private static final int COUNT = 3;

    @BeforeEach
    void setup () {
        lottos = new Lottos(자동_로또, COUNT) {
            @Override
            public List<Lotto> createLotto(LottoStrategy lottoStrategy, int count) {
                return 로또_티켓별_번호;
            }
        };

    }

    @Test
    void round_count_test() {
        // When & Then
        assertThat(lottos.getLottoList())
                .hasSize(COUNT);
    }

    @Test
    @DisplayName("당첨번호와 일치하는 로또 티켓 (묶음) 테스트 (로또 티켓에는 꽝 2개 2등 하나) ")
    void getMatchCounts_returnsCorrectMatchCounts() {
        // When & Then
        assertThat(lottos.getMatchCounts(지난주_로또_당첨))
                .hasSize(2);
    }

}