package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("로또 매칭 결과 테스트")
public class LottoStatisticTest {

    private WinningLottoTicket winningLottoTicket;

    @BeforeEach
    void setUp() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        winningLottoTicket = new WinningLottoTicket(winningNumbers, 7);
    }

    static Stream<Arguments> provideLottoTickets() {
        return Stream.of(
                Arguments.of(
                        Collections.singletonList(new LottoTicket(new int[]{1, 2, 3, 4, 5, 7})),
                        LottoRank.SECOND_PLACE, 1
                ),
                Arguments.of(
                        Collections.singletonList(new LottoTicket(new int[]{1, 2, 3, 4, 5, 8})),
                        LottoRank.THIRD_PLACE, 1
                )
        );
    }

    @ParameterizedTest(name = "{0} -> {1}")
    @MethodSource("provideLottoTickets")
    @DisplayName("로또 보너스볼 매칭 확인")
    void matchLottoBonusWithMethod(List<LottoTicket> lottoTicketsList, LottoRank lottoRank, int expected) {
        // given
        LottoTickets lottoTickets = new LottoTickets(lottoTicketsList);

        // when
        LottoStatistic lottoStatistic = lottoTickets.matchLottoTickets(winningLottoTicket);
        int rankCount = lottoStatistic.getRankCount(lottoRank);

        // then
        assertThat(rankCount).isEqualTo(expected);
    }

    @Test
    @DisplayName("로또 여러개 당첨 확인")
    void matchLottoTwoTest() {
        // given
        List<LottoTicket> lottoTicketsList = Arrays.asList(
                new LottoTicket(new int[]{1, 2, 3, 4, 5, 6}),
                new LottoTicket(new int[]{1, 2, 3, 4, 5, 45}),
                new LottoTicket(new int[]{1, 2, 3, 4, 44, 45})
        );
        LottoTickets lottoTickets = new LottoTickets(lottoTicketsList);

        // when
        LottoStatistic lottoStatistic = lottoTickets.matchLottoTickets(winningLottoTicket);
        int countMatchSix = lottoStatistic.getRankCount(LottoRank.FIRST_PLACE);
        int countMatchFive = lottoStatistic.getRankCount(LottoRank.THIRD_PLACE);
        int countMatchFour = lottoStatistic.getRankCount(LottoRank.FOURTH_PLACE);
        int countMatchThree = lottoStatistic.getRankCount(LottoRank.FIFTH_PLACE);

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
    void matchLottoOverlapTest() {
        // given
        LottoTicket lottoTicket = new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
        List<LottoTicket> lottoTicketsList = Arrays.asList(lottoTicket, lottoTicket);
        LottoTickets lottoTickets = new LottoTickets(lottoTicketsList);

        // when
        LottoStatistic lottoStatistic = lottoTickets.matchLottoTickets(winningLottoTicket);
        int actual = lottoStatistic.getRankCount(LottoRank.FIRST_PLACE);

        // then
        assertThat(actual).isEqualTo(2);
    }

    @Test
    @DisplayName("수익률 확인")
    void profitRateTest() {
        // given
        List<LottoTicket> lottoTicketsList = Collections.singletonList(new LottoTicket(new int[]{1, 2, 3, 11, 12, 13}));
        LottoTickets lottoTickets = new LottoTickets(lottoTicketsList);

        // when
        LottoStatistic lottoStatistic = lottoTickets.matchLottoTickets(winningLottoTicket);
        Double profitRate = lottoStatistic.getProfitRate(10000);

        // then
        assertThat(profitRate).isEqualTo(0.5);
    }
}
