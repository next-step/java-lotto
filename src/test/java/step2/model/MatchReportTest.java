package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MatchReportTest {

    @DisplayName("create() 정적 생성자는 null을 입력하면 예외를 발생한다")
    @MethodSource("provideMatchReportForCreate")
    @ParameterizedTest
    void create_Null_ExceptionThrown(MoneyAmount moneyAmount, MatchResult matchResult) {
        assertThatThrownBy(() -> MatchReport.create(moneyAmount, matchResult))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> provideMatchReportForCreate() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(LottoData.createMoneyAmount(1), null),
                Arguments.of(null, MatchResult.create())
        );
    }

    @DisplayName("calculateEarningRate() 메서드는 총 상금에서 구입 금액을 나눈 값을 반환한다")
    @Test
    void calculateEarningRate_MoneyAndMatchResult_RateOfReturn() {
        MoneyAmount moneyAmount = LottoData.createMoneyAmount(1_000);
        moneyAmount.useAmount(Money.valueOf(1_000));
        MatchResult matchResult = LottoData.createMatchResult(LottoRank.FIRST, 1);
        MatchReport matchReport = MatchReport.create(moneyAmount, matchResult);

        assertThat(matchReport.calculateEarningRate()).isEqualTo(BigDecimal.valueOf(200_000_000,2));
    }
}
