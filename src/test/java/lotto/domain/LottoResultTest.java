package lotto.domain;

import lotto.dto.PurchaseMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static lotto.domain.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("LottoResultTest 테스트")
class LottoResultTest {

    @DisplayName("getAllPrize_정상")
    @ParameterizedTest
    @MethodSource("provideSource_getAllPrize_정상")
    void getAllPrize_정상(LottoResult lottoResult, long expectedResult) {
        // When
        long actualResult = lottoResult.getAllPrize();

        // Then
        assertThat(expectedResult).isEqualTo(actualResult);
    }

    static Stream<Arguments> provideSource_getAllPrize_정상() {
        LottoResult case1LottoResult = new LottoResult();
        case1LottoResult.put(FIRST);
        long case1ExpectedResult = 2_000_000_000L;

        LottoResult case2LottoResult = new LottoResult();
        case2LottoResult.put(FIRST);
        case2LottoResult.put(SECOND);
        case2LottoResult.put(SECOND);
        long case2ExpectedResult = 2_060_000_000L;

        LottoResult case3LottoResult = new LottoResult();
        case3LottoResult.put(FIRST);
        case3LottoResult.put(FIRST);
        case3LottoResult.put(SECOND);
        case3LottoResult.put(THIRD);
        long case3ExpectedResult = 4_031_500_000L;

        LottoResult case4LottoResult = new LottoResult();
        case4LottoResult.put(FIRST);
        case4LottoResult.put(SECOND);
        case4LottoResult.put(THIRD);
        case4LottoResult.put(FOURTH);
        long case4ExpectedResult = 2_031_550_000L;

        return Stream.of(
                Arguments.of(case1LottoResult, case1ExpectedResult),
                Arguments.of(case2LottoResult, case2ExpectedResult),
                Arguments.of(case3LottoResult, case3ExpectedResult),
                Arguments.of(case4LottoResult, case4ExpectedResult)
        );
    }

    @DisplayName("getProfit_정상")
    @ParameterizedTest
    @MethodSource("provideSource_getProfit_정상")
    void getProfit_정상(LottoResult lottoResult, PurchaseMoney purchaseMoney, double expectedResult) {
        // When
        double actualResult = lottoResult.getProfit(purchaseMoney);

        // Then
        assertThat(expectedResult).isEqualTo(actualResult);
    }

    static Stream<Arguments> provideSource_getProfit_정상() {
        LottoResult case1LottoResult = new LottoResult();
        case1LottoResult.put(THIRD);
        PurchaseMoney case1PurchaseMoney = new PurchaseMoney(12_000_000);
        double case1ExpectedResult = 0.125D;

        LottoResult case2LottoResult = new LottoResult();
        case2LottoResult.put(FIRST);
        case2LottoResult.put(THIRD);
        case2LottoResult.put(THIRD);
        PurchaseMoney case2PurchaseMoney = new PurchaseMoney(1_001_500_000);
        double case2ExpectedResult = 2.0D;

        LottoResult case3LottoResult = new LottoResult();
        case3LottoResult.put(FIFTH);
        PurchaseMoney case3PurchaseMoney = new PurchaseMoney(50_000);
        double case3ExpectedResult = 0.1D;

        LottoResult case4LottoResult = new LottoResult();
        case4LottoResult.put(SECOND);
        PurchaseMoney case4PurchaseMoney = new PurchaseMoney(60_000_000);
        double case4ExpectedResult = 0.5D;

        return Stream.of(
                Arguments.of(case1LottoResult, case1PurchaseMoney, case1ExpectedResult),
                Arguments.of(case2LottoResult, case2PurchaseMoney, case2ExpectedResult),
                Arguments.of(case3LottoResult, case3PurchaseMoney, case3ExpectedResult),
                Arguments.of(case4LottoResult, case4PurchaseMoney, case4ExpectedResult)
        );
    }
}