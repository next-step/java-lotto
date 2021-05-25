package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

import static java.math.BigDecimal.valueOf;
import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoResultTest 테스트")
class LottoResultTest {

    @DisplayName("getAllPrize_정상")
    @ParameterizedTest
    @MethodSource("provideSource_getAllPrize_정상")
    void getAllPrize_정상(LottoResult lottoResult, BigDecimal expectedResult) {
        // When
        BigDecimal actualResult = lottoResult.getAllPrize();

        // Then
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    static Stream<Arguments> provideSource_getAllPrize_정상() {
        LottoResult case1 = new LottoResult();
        case1.put(FIRST);
        BigDecimal case1Result = valueOf(2_000_000_000L);

        LottoResult case2 = new LottoResult();
        case2.put(FIRST);
        case2.put(SECOND);
        case2.put(SECOND);
        BigDecimal case2Result = valueOf(2_003_000_000L);

        LottoResult case3 = new LottoResult();
        case3.put(FIRST);
        case3.put(FIRST);
        case3.put(SECOND);
        case3.put(THIRD);
        BigDecimal case3Result = valueOf(4_001_550_000L);

        LottoResult case4 = new LottoResult();
        case4.put(FIRST);
        case4.put(SECOND);
        case4.put(THIRD);
        case4.put(FOURTH);
        BigDecimal case4Result = valueOf(2_001_555_000L);

        return Stream.of(
                Arguments.of(case1, case1Result),
                Arguments.of(case2, case2Result),
                Arguments.of(case3, case3Result),
                Arguments.of(case4, case4Result)
                );
    }
}