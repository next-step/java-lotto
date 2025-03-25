package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SellerTest {

    @ParameterizedTest
    @MethodSource("sellTestData")
    @DisplayName("구매 금액을 받아 1000원당 1장으로 로또를 판매한다.")
    void sellTest(int money, int expected) {
        var lottos = Seller.sell(money);

        Assertions.assertThat(lottos).hasSize(expected);
    }

    private static Stream<Arguments> sellTestData() {
        return Stream.of(
                Arguments.of(14000, 14),
                Arguments.of(4000, 4),
                Arguments.of(10000, 10)
        );
    }
}
