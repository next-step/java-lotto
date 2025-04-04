package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class SellerTest {

    @ParameterizedTest
    @MethodSource("sellTestData")
    @DisplayName("구매 금액을 받아 1000원당 1장으로 로또를 판매한다.")
    void sellTest(int money, int expected, List<List<Integer>> pickedNumbers) {
        var seller = new Seller();

        var lottos = seller.sell(money, pickedNumbers);

        var manualLottoCount = lottos.stream()
                .filter(LottoGame::isManual)
                .count();

        Assertions.assertThat(lottos).hasSize(expected);
        Assertions.assertThat(manualLottoCount).isEqualTo(pickedNumbers.size());
    }

    private static Stream<Arguments> sellTestData() {
        return Stream.of(
                Arguments.of(14000, 14, List.of(List.of(1, 2, 3, 4, 5, 6))),
                Arguments.of(4000, 4, List.of(List.of(1, 2, 3, 4, 5, 6))),
                Arguments.of(10000, 10, List.of(List.of(1, 2, 3, 4, 5, 6)))
        );
    }
}
