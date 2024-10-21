package lottogame.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoPurchaseTest {

    @DisplayName("로또 구매정보가 생성된다.")
    @ParameterizedTest
    @MethodSource("provideLottoPurchaseTestCases")
    void testLottoPurchaseCreation(int totalAmount, int manualCount, int expectedAutoCount, int expectedTotalCount) {
        LottoPurchase purchase = new LottoPurchase(totalAmount, manualCount);

        assertEquals(totalAmount, purchase.getTotalAmount());
        assertEquals(manualCount, purchase.getManualCount());
        assertEquals(expectedAutoCount, purchase.getAutoCount());
        assertEquals(expectedTotalCount, purchase.getTotalCount());
    }

    private static Stream<Arguments> provideLottoPurchaseTestCases() {
        return Stream.of(
                Arguments.of(14000, 3, 11, 14),
                Arguments.of(5000, 2, 3, 5),
                Arguments.of(1000, 0, 1, 1),
                Arguments.of(20000, 10, 10, 20)
        );
    }
}
