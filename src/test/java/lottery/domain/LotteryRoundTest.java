package lottery.domain;

import lottery.strategy.ManualTicketIssueStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryRoundTest {
    private LotteryTicket roundTicket;
    private LotteryNumber bonusNumber;

    public static LotteryTicket issueTicket(List<Integer> lotteryInts) {
        return new ManualTicketIssueStrategy(lotteryInts).issue();
    }

    static Stream<Arguments> resultTest() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 6, 2000000000, 2000000.0),
                Arguments.of(List.of(2, 3, 4, 5, 6, 7), 5, 30000000, 30000.0),
                Arguments.of(List.of(2, 3, 4, 5, 6, 10), 5, 1500000, 1500.0),
                Arguments.of(List.of(3, 4, 5, 6, 7, 11), 4, 50000, 50.0),
                Arguments.of(List.of(4, 5, 6, 10, 11, 12), 3, 5000, 5.0),
                Arguments.of(List.of(5, 6, 10, 11, 12, 13), 0, 0, 0.0),
                Arguments.of(List.of(6, 7, 11, 12, 13, 14), 0, 0, 0.0),
                Arguments.of(List.of(7, 11, 12, 13, 14, 15), 0, 0, 0.0)
        );
    }

    @BeforeEach
    void setUp() {
        List<Integer> roundInts = List.of(1, 2, 3, 4, 5, 6);
        roundTicket = issueTicket(roundInts);
        bonusNumber = new LotteryNumber(7);
    }

    @Test
    @DisplayName("로또 라운드 생성")
    void create() {
        // given
        LotteryRound lotteryRound = new LotteryRound(roundTicket, bonusNumber);

        // then
        assertThat(lotteryRound).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("resultTest")
    @DisplayName("로또 회차에 번호 넣으면 당첨 번호 갯수와 금액, 수익률 정보 반환")
    void getRoundResult(List<Integer> lotteryInts, int matchingCount, int prizeMoney, double profitRate) {
        // given
        LotteryRound lotteryRound = new LotteryRound(roundTicket, bonusNumber);
        LotteryTicket ticket = issueTicket(lotteryInts);

        // when
        LotteryPrize lotteryPrize = lotteryRound.match(ticket);

        // then
        assertThat(lotteryPrize).isNotNull();
        assertThat(lotteryPrize.calculateMatchingCount()).isEqualTo(matchingCount);
        assertThat(lotteryPrize.calculatePrizeMoney()).isEqualTo(prizeMoney);
        assertThat(LotteryPrize.calculateProfitRate(List.of(lotteryPrize))).isEqualTo(profitRate);
    }

    @Test
    @DisplayName("로또 회차에 당첨 번호 리스트 넣으면 당첨 결과 리스트 생성")
    void getRoudResults() {
        // given
        LotteryRound lotteryRound = new LotteryRound(roundTicket, bonusNumber);
        int money = 6000;
        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        lotteryTickets.add(issueTicket(List.of(1, 2, 3, 4, 5, 6)));
        lotteryTickets.add(issueTicket(List.of(2, 3, 4, 5, 6, 7)));
        lotteryTickets.add(issueTicket(List.of(2, 3, 4, 5, 6, 10)));
        lotteryTickets.add(issueTicket(List.of(3, 4, 5, 6, 10, 11)));
        lotteryTickets.add(issueTicket(List.of(4, 5, 6, 10, 11, 12)));
        lotteryTickets.add(issueTicket(List.of(5, 6, 10, 11, 12, 13)));

        // when
        List<LotteryPrize> lotteryPrizes = lotteryRound.matches(lotteryTickets);
        int totalMatchingCount = lotteryPrizes.stream()
                .map(LotteryPrize::calculateMatchingCount)
                .reduce(0, Integer::sum);
        long totalPrizeMoney = lotteryPrizes.stream()
                .map(LotteryPrize::calculatePrizeMoney)
                .reduce(0L, Long::sum);

        // then
        assertThat(lotteryPrizes).isNotNull();
        assertThat(lotteryPrizes.size()).isEqualTo(6);
        assertThat(totalMatchingCount).isEqualTo(23);
        assertThat(totalPrizeMoney).isEqualTo(2_031_555_000L);
        assertThat(LotteryPrize.calculateProfitRate(lotteryPrizes)).isEqualTo((double) 2_031_555_000L / money);
    }
}