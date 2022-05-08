package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class StoreTest {

    @ParameterizedTest
    @MethodSource("로또_구매_갯수_매개변수")
    void 로또_구매_성공(int purchaseAmount, int lottoAmount) {
        assertThat(Store.buyLotto(new PurchaseAmount(purchaseAmount))).isEqualTo(lottoAmount);
    }

    static Stream<Arguments> 로또_구매_갯수_매개변수() {
        return Stream.of(
                arguments(1000, 1),
                arguments(2500, 2)
        );
    }
}
