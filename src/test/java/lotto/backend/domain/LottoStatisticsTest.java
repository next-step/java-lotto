package lotto.backend.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    LottoTicket winning;
    LottoTickets lotto;
    LottoStatistics lottoStatistics;

    @BeforeEach
    void setUp() {
        this.winning = LottoTicket.of(new int[]{1, 7, 10, 23, 40, 42});
        this.lotto = new LottoTickets(
                List.of(
                        LottoTicket.of(new int[]{1, 7, 10, 23, 40, 42}), //6개 모두 일치
                        LottoTicket.of(new int[]{2, 4, 10, 23, 40, 42}) //4개 일치
                )
        );
        this.lottoStatistics = new LottoStatistics(winning, lotto);
    }

    @ParameterizedTest(name = "[{index}] 숫자 {0}개가 일치하는 로또는 {1}개")
    @CsvSource({"6,1", "5,0", "4,1", "3,0"})
    @DisplayName("일치하는 로또 갯수 카운트")
    void macth_lotto_count(int match, int count) {
        assertThat(lottoStatistics.printMatch(match)).isEqualTo(count);
    }

    @Test
    @DisplayName("수익률 계산 로또 2장구매 = 1등 + 4등")
    void profit() {
        double expected = (LottoRank.of(6).getPrize() + LottoRank.of(4).getPrize()) / lotto.orderAmount();
        assertThat(lottoStatistics.printProfit()).isEqualTo(expected);
    }
}
