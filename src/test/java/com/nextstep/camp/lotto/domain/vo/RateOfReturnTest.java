package com.nextstep.camp.lotto.domain.vo;

import java.util.stream.Stream;

import com.nextstep.camp.lotto.domain.type.ProfitType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RateOfReturnTest {

    static Stream<TestCase> provideRateCases() {
        return Stream.of(
            new TestCase(2000, 1000, "2.00", ProfitType.PROFIT),
            new TestCase(1000, 1000, "1.00", ProfitType.BREAK_EVEN),
            new TestCase(500, 1000, "0.50", ProfitType.LOSS)
        );
    }

    @ParameterizedTest(name = "{0}")
    @MethodSource("provideRateCases")
    void test_rate_of_return(TestCase testCase) {
        LottoAmount spent = LottoAmount.of(testCase.getSpent());
        RateOfReturn rate = RateOfReturn.of(testCase.getTotalPrize(), spent);

        assertEquals(testCase.getExpectedRateString(), rate.toString());
        assertEquals(testCase.getExpectedProfitType(), rate.getProfitType());
    }

    static class TestCase {
        private final int totalPrize;
        private final int spent;
        private final String expectedRateString;
        private final ProfitType expectedProfitType;

        public TestCase(int totalPrize, int spent, String expectedRateString, ProfitType expectedProfitType) {
            this.totalPrize = totalPrize;
            this.spent = spent;
            this.expectedRateString = expectedRateString;
            this.expectedProfitType = expectedProfitType;
        }

        public int getTotalPrize() {
            return totalPrize;
        }

        public int getSpent() {
            return spent;
        }

        public String getExpectedRateString() {
            return expectedRateString;
        }

        public ProfitType getExpectedProfitType() {
            return expectedProfitType;
        }

        @Override
        public String toString() {
            return String.format("RateOfReturn{totalPrize=%d, spent=%d}", totalPrize, spent);
        }
    }
}
