package lotto.domain.model.game;

import lotto.domain.model.lotto.BonusNumber;
import lotto.domain.model.lotto.LottoNumber;
import lotto.domain.model.lotto.LottoTicket;
import lotto.domain.model.lotto.WinningLottoTicket;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    private static final WinningLottoTicket WINNING_TICKET = new WinningLottoTicket(
            numbers(1, 2, 3, 4, 5, 6), new BonusNumber(7)
    );

    @ParameterizedTest(name = "{0}")
    @MethodSource("scenarios")
    void calculateLottoGameResult(
            final String description, final List<LottoTicket> tickets,
            final Map<Rank, Integer> expectedRanks, final Prize expectedPrize) {
        LottoGameResult result = new LottoGame(tickets, WINNING_TICKET).draw();

        expectedRanks.forEach((rank, count) -> 
            assertThat(result.getRankCountMap().get(rank)).isEqualTo(count));
        assertThat(result.getTotalPrize()).isEqualTo(expectedPrize);
    }
    
    private static Stream<Arguments> scenarios() {
        return Stream.of(
            allRanksScenario(),
            noTicketsScenario(),
            allMissScenario(),
            onlyBonusMatchScenario()
        );
    }
    
    private static Arguments allRanksScenario() {
        List<LottoTicket> tickets = tickets(
            numbers(1, 2, 3, 4, 5, 6),  // 1등
            numbers(1, 2, 3, 4, 5, 7),  // 2등
            numbers(1, 2, 3, 4, 5, 8),  // 3등
            numbers(1, 2, 3, 4, 9, 10), // 4등
            numbers(1, 2, 3, 11, 12, 13), // 5등
            numbers(1, 2, 14, 15, 16, 17)  // 낙첨
        );
        
        Map<Rank, Integer> expectedRanks = Map.of(
            Rank.FIRST, 1, Rank.SECOND, 1, Rank.THIRD, 1, 
            Rank.FOURTH, 1, Rank.FIFTH, 1, Rank.MISS, 1
        );
        
        Prize expectedPrize = prize(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH);
        
        return Arguments.of("모든 등수 포함", tickets, expectedRanks, expectedPrize);
    }
    
    private static Arguments noTicketsScenario() {
        List<LottoTicket> tickets = Collections.emptyList();
        Map<Rank, Integer> expectedRanks = Collections.emptyMap();
        Prize expectedPrize = Prize.zero();
        
        return Arguments.of("티켓 없음", tickets, expectedRanks, expectedPrize);
    }
    
    private static Arguments allMissScenario() {
        List<LottoTicket> tickets = tickets(
            numbers(10, 11, 12, 13, 14, 15),
            numbers(20, 21, 22, 23, 24, 25)
        );
        
        Map<Rank, Integer> expectedRanks = Map.of(Rank.MISS, 2);
        Prize expectedPrize = Prize.zero();
        
        return Arguments.of("모두 낙첨", tickets, expectedRanks, expectedPrize);
    }
    
    private static Arguments onlyBonusMatchScenario() {
        List<LottoTicket> tickets = tickets(numbers(7, 11, 12, 13, 14, 15));
        Map<Rank, Integer> expectedRanks = Map.of(Rank.MISS, 1);
        Prize expectedPrize = Prize.zero();
        
        return Arguments.of("보너스 번호만 일치", tickets, expectedRanks, expectedPrize);
    }

    @SafeVarargs
    private static List<LottoTicket> tickets(final Set<LottoNumber>... numberSets) {
        return Arrays.stream(numberSets).map(LottoTicket::new).collect(Collectors.toUnmodifiableList());
    }

    private static Set<LottoNumber> numbers(final int... values) {
        Set<LottoNumber> lottoNumbers = new TreeSet<>();
        for (int value : values) {
            lottoNumbers.add(new LottoNumber(value));
        }
        return lottoNumbers;
    }
    
    private static Prize prize(Rank... ranks) {
        return Arrays.stream(ranks)
                .map(Rank::getWinningPrize)
                .reduce(Prize.zero(), Prize::add);
    }
} 
