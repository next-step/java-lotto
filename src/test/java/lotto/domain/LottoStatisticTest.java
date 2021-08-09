package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("로또 매칭 결과 테스트")
public class LottoStatisticTest {

    private List<Integer> winningNumbers;

    @BeforeEach
    void setUp() {
        winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("로또 여러개 당첨 확인")
    void lottoMatchTwoTest() {
        // given
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(new LottoTicket(new int[]{1, 2, 3, 4, 5, 6}));
        lottoTickets.add(new LottoTicket(new int[]{1, 2, 3, 4, 5, 45}));
        lottoTickets.add(new LottoTicket(new int[]{1, 2, 3, 4, 44, 45}));

        // when
        LottoStatistic lottoStatistic = lottoTickets.matchLottoTickets(winningNumbers);
        int countMatchSix = lottoStatistic.getRankCount(LottoRank.FIRST_PLACE);
        int countMatchFive = lottoStatistic.getRankCount(LottoRank.SECOND_PLACE);
        int countMatchFour = lottoStatistic.getRankCount(LottoRank.THIRD_PACE);
        int countMatchThree = lottoStatistic.getRankCount(LottoRank.FOURTH_PLACE);

        // then
        assertAll(
                () -> assertThat(countMatchSix).isEqualTo(1),
                () -> assertThat(countMatchFive).isEqualTo(1),
                () -> assertThat(countMatchFour).isEqualTo(1),
                () -> assertThat(countMatchThree).isEqualTo(0)
        );
    }

    @Test
    @DisplayName("로또 중복 당첨 확인")
    void lottoMatchOverlapTest() {
        // given
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(new LottoTicket(new int[]{1, 2, 3, 4, 5, 6}));
        lottoTickets.add(new LottoTicket(new int[]{1, 2, 3, 4, 5, 6}));

        // when
        LottoStatistic lottoStatistic = lottoTickets.matchLottoTickets(winningNumbers);
        int actual = lottoStatistic.getRankCount(LottoRank.FIRST_PLACE);

        // then
        assertThat(actual).isEqualTo(2);
    }

    @Test
    @DisplayName("수익률 확인")
    void profitRateTest() {
        // given
        int[] lottoNumbers = {1, 2, 3, 11, 12, 13};
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        LottoTickets lottoTickets = new LottoTickets();
        lottoTickets.add(lottoTicket);

        // when
        LottoStatistic lottoStatistic = lottoTickets.matchLottoTickets(winningNumbers);
        Double profitRate = lottoStatistic.getProfitRate(10000);

        // then
        assertThat(profitRate).isEqualTo(0.5);
    }
}
