package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Constants;
import step2.domain.strategy.TestLottoGeneratorStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 티켓 테스트")
class LottoTicketTest {

    private LottoTicket lottoTicket = new LottoTicket(Arrays.asList(new Lotto(new TestLottoGeneratorStrategy()),new Lotto(new TestLottoGeneratorStrategy())));

    @BeforeEach
    void setUp() {
        lottoTicket.generateLotto();
    }

    @DisplayName("로또 번호 생성 호출")
    @Test
    void generateLotto() {
        assertThat(lottoTicket.getLottoList().get(0).toString()).isEqualTo(Constants.TEST_LOTTO_NUMBERS);
    }

    @DisplayName("로또 당첨 횟수 계산")
    @Test
    void calcWinLottoCountMap() {
        int matchCount = 6;
        lottoTicket.calcWinLottoCountMap(Constants.TEST_WINNER_NUMBERS);
        assertThat(lottoTicket.getWinLottoCountMap().get(matchCount)).isEqualTo(1);
    }
}
