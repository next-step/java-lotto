package com.nextstep.camp.lotto.domain.entity;

import java.util.List;
import java.util.stream.Stream;

import com.nextstep.camp.lotto.domain.vo.WinningNumbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketTest {

    static Stream<TestCase> provideMatchCases() {
        return Stream.of(
            new TestCase(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 6),
            new TestCase(List.of(10, 20, 30, 40, 41, 42), List.of(1, 2, 3, 4, 5, 6), 0),
            new TestCase(List.of(1, 2, 3, 10, 11, 12), List.of(1, 2, 3, 4, 5, 6), 3)
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provideMatchCases")
    void countMatch_returns_expected(TestCase testCase) {
        LottoTicket ticket = LottoTicket.of(testCase.getLottoNumbers());
        WinningNumbers winning = WinningNumbers.of(testCase.getWinningNumbers());
        assertEquals(testCase.getExpectedMatchCount(), ticket.countMatch(winning));
    }

    private static class TestCase {
        private final List<Integer> lottoNumbers;
        private final List<Integer> winningNumbers;
        private final int expectedMatchCount;

        private TestCase(List<Integer> lottoNumbers, List<Integer> winningNumbers, int expectedMatchCount) {
            this.lottoNumbers = lottoNumbers;
            this.winningNumbers = winningNumbers;
            this.expectedMatchCount = expectedMatchCount;
        }

        public List<Integer> getLottoNumbers() {
            return lottoNumbers;
        }

        public List<Integer> getWinningNumbers() {
            return winningNumbers;
        }

        public int getExpectedMatchCount() {
            return expectedMatchCount;
        }

        @Override
        public String toString() {
            return "TestCase{" +
                "lottoNumbers=" + lottoNumbers +
                ", winningNumbers=" + winningNumbers +
                ", expectedMatchCount=" + expectedMatchCount +
                '}';
        }
    }
}