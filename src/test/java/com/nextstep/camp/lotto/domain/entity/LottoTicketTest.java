package com.nextstep.camp.lotto.domain.entity;

import java.util.List;
import java.util.stream.Stream;

import com.nextstep.camp.lotto.domain.type.MatchResult;
import com.nextstep.camp.lotto.domain.vo.LottoNumber;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketTest {

    static Stream<TestCase> provideMatchCases() {
        return Stream.of(
            new TestCase(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 7, MatchResult.SIX),
            new TestCase(List.of(1, 2, 3, 4, 5, 7), List.of(1, 2, 3, 4, 5, 6), 7, MatchResult.FIVE_BONUS),
            new TestCase(List.of(1, 2, 3, 4, 5, 8), List.of(1, 2, 3, 4, 5, 6), 7, MatchResult.FIVE),
            new TestCase(List.of(10, 20, 30, 40, 41, 42), List.of(1, 2, 3, 4, 5, 6), 7, MatchResult.NONE),
            new TestCase(List.of(1, 2, 3, 10, 11, 12), List.of(1, 2, 3, 4, 5, 6), 7, MatchResult.THREE)
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provideMatchCases")
    void match_returns_expected_match_result(TestCase testCase) {
        LottoTicket ticket = LottoTicket.of(testCase.getLottoNumbers());

        WinningNumbers winning = WinningNumbers.of(testCase.getWinningNumbers())
            .withBonusNumber(LottoNumber.of(testCase.getBonusNumber()));

        MatchResult result = ticket.match(winning);
        assertEquals(testCase.getExpected(), result);
    }

    private static class TestCase {
        private final List<Integer> lottoNumbers;
        private final List<Integer> winningNumbers;
        private final int bonusNumber;
        private final MatchResult expected;

        private TestCase(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber, MatchResult expected) {
            this.lottoNumbers = lottoNumbers;
            this.winningNumbers = winningNumbers;
            this.bonusNumber = bonusNumber;
            this.expected = expected;
        }

        public List<Integer> getLottoNumbers() {
            return lottoNumbers;
        }

        public List<Integer> getWinningNumbers() {
            return winningNumbers;
        }

        public int getBonusNumber() {
            return bonusNumber;
        }

        public MatchResult getExpected() {
            return expected;
        }

        @Override
        public String toString() {
            return "TestCase{" +
                "lottoNumbers=" + lottoNumbers +
                ", winningNumbers=" + winningNumbers +
                ", bonus=" + bonusNumber +
                ", expected=" + expected +
                '}';
        }
    }
}