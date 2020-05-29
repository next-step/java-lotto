package lotto.domain.winning;

import lotto.domain.generator.FixedNumberGenerator;
import lotto.domain.generator.NumberGenerator;
import lotto.domain.lotto.LottoRank;
import lotto.domain.lotto.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("WinningStatistics 클래스 테스트")
public class WinningStatisticsTest {
    String winningNumberString = "1,2,3,4,5,6";

    @DisplayName("WinningStatistics 객체를 생성할 수 있다.")
    @Test
    void create() {
        int lottoCount = 2;
        LottoTicket lottoTicket = new LottoTicket(lottoCount, new FixedNumberGenerator());

        Map<LottoRank, Long> lottoRankMap = lottoTicket.matchWinningNumber(new WinningNumbers(winningNumberString));
        WinningStatistics winningStatistics = new WinningStatistics(lottoTicket.getLottoNumbersCount(), lottoRankMap);

        Map<LottoRank, Long> lottoRank = winningStatistics.getLottoRank();

        assertThat(lottoRank.get(LottoRank.FIRST)).isEqualTo(new Long(lottoCount));
    }

    @DisplayName("WinningStatistics 객체 생성시 LottoRank MISS는 삭제한다.")
    @Test
    void create_remove_miss() {
        int lottoCount = 2;
        LottoTicket lottoTicket = new LottoTicket(lottoCount, new NotMatchNumberGenerator());

        Map<LottoRank, Long> lottoRankMap = lottoTicket.matchWinningNumber(new WinningNumbers(winningNumberString));
        WinningStatistics winningStatistics = new WinningStatistics(lottoTicket.getLottoNumbersCount(), lottoRankMap);

        Map<LottoRank, Long> lottoRank = winningStatistics.getLottoRank();

        assertThat(lottoRank).isEmpty();
    }

    private static class NotMatchNumberGenerator implements NumberGenerator {
        @Override
        public List<Integer> getNumbers() {
            return Arrays.asList(7, 8, 9, 10, 11, 12);
        }
    }
}
