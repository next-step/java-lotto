package com.nextstep.camp.lotto.domain.entity;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.nextstep.camp.lotto.domain.strategy.LottoFixedPicker;
import com.nextstep.camp.lotto.domain.type.MatchResult;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketsTest {

    static Stream<TestCase> provideMatchResults() {
        return Stream.of(
            new TestCase(
                List.of(
                    List.of(1, 2, 3, 4, 5, 6),
                    List.of(1, 2, 3, 4, 5, 7),
                    List.of(10, 20, 30, 40, 41, 42)
                ),
                List.of(1, 2, 3, 4, 5, 6),
                List.of(MatchResult.SIX, MatchResult.FIVE, MatchResult.NONE)
            )
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provideMatchResults")
    void matchAll_returns_expected_results(TestCase testCase) {
        List<LottoTicket> tickets = testCase.getLottoNumbers().stream()
            .map(LottoTicket::of)
            .collect(Collectors.toList());

        List<LottoTicket> lottoTicketList = LottoFixedPicker.of(tickets).pick();
        LottoTickets lottoTickets = LottoTickets.of(lottoTicketList);
        WinningNumbers winning = WinningNumbers.of(testCase.getWinningNumbers());

        List<MatchResult> actual = lottoTickets.matchAll(winning);
        assertEquals(testCase.getExpectedResults(), actual);
    }

    private static class TestCase {
        private final List<List<Integer>> lottoNumbers;
        private final List<Integer> winningNumbers;
        private final List<MatchResult> expectedResults;

        private TestCase(List<List<Integer>> lottoNumbers, List<Integer> winningNumbers, List<MatchResult> expectedResults) {
            this.lottoNumbers = lottoNumbers;
            this.winningNumbers = winningNumbers;
            this.expectedResults = expectedResults;
        }

        public List<List<Integer>> getLottoNumbers() {
            return lottoNumbers;
        }

        public List<Integer> getWinningNumbers() {
            return winningNumbers;
        }

        public List<MatchResult> getExpectedResults() {
            return expectedResults;
        }

        @Override
        public String toString() {
            return "TestCase{" +
                "lottoNumbers=" + lottoNumbers +
                ", winningNumbers=" + winningNumbers +
                ", expectedResults=" + expectedResults +
                '}';
        }
    }
}
