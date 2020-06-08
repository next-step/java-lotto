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

    @DisplayName("정적 생성자는 null을 입력하면 예외 발생")
    @MethodSource("provideMatchReportForCreate")
    @ParameterizedTest
    void createExceptionThrown(MoneyAmount moneyAmount, MatchResult matchResult) {
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

    @DisplayName("총 당첨금에서 구입 금액을 나눈 값을 계산하여 반환")
    @Test
    void calculateEarningRate() {
        MoneyAmount moneyAmount = LottoData.createMoneyAmount(1_000);
        moneyAmount.useAmount(Money.valueOf(1_000));
        MatchResult matchResult = LottoData.createMatchResult(LottoRank.FIRST, 1);
        MatchReport matchReport = MatchReport.create(moneyAmount, matchResult);

        assertThat(matchReport.calculateEarningRate()).isEqualTo(BigDecimal.valueOf(200_000_000,2));
    }
}
