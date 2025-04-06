package com.nextstep.camp.lotto.domain.entity;

import java.util.List;
import java.util.stream.Stream;

import com.nextstep.camp.lotto.domain.type.Rank;
import com.nextstep.camp.lotto.domain.vo.LottoNumber;
import com.nextstep.camp.lotto.domain.vo.LottoNumbers;
import com.nextstep.camp.lotto.domain.vo.WinningNumbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketTest {

    static Stream<TestCase> provideMatchCases() {
        return Stream.of(
            new TestCase(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6), 7, Rank.SIX),
            new TestCase(List.of(1, 2, 3, 4, 5, 7), List.of(1, 2, 3, 4, 5, 6), 7, Rank.FIVE_BONUS),
            new TestCase(List.of(1, 2, 3, 4, 5, 8), List.of(1, 2, 3, 4, 5, 6), 7, Rank.FIVE),
            new TestCase(List.of(10, 20, 30, 40, 41, 42), List.of(1, 2, 3, 4, 5, 6), 7, Rank.NONE),
            new TestCase(List.of(1, 2, 3, 10, 11, 12), List.of(1, 2, 3, 4, 5, 6), 7, Rank.THREE)
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provideMatchCases")
    void match_returns_expected_match_result(TestCase testCase) {
        LottoTicket ticket = LottoTicket.of(testCase.getLottoNumbers());
        LottoNumbers lottoNumbers = LottoNumbers.of(testCase.getWinningNumbers());

        LottoNumber bonusNumber = LottoNumber.of(testCase.getBonusNumber());
        WinningNumbers winning = WinningNumbers.of(lottoNumbers, bonusNumber);

        Rank result = ticket.match(winning);
        assertEquals(testCase.getExpected(), result);
    }

    private static class TestCase {
        private final List<Integer> lottoNumbers;
        private final List<Integer> winningNumbers;
        private final int bonusNumber;
        private final Rank expected;

        private TestCase(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber, Rank expected) {
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

        public Rank getExpected() {
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