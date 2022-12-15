package lotto.domain;

import lotto.strategy.ManualNumberStrategy;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PurchasingTest {

    @ParameterizedTest
    @ValueSource(strings = {"1000", "1001", "1999"})
    void 금액_로또_개수(String number) {
        assertThat(new Purchasing(new Money(number), new ArrayList<>()).getRandomCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource("provideLottoCount")
    void 수동(String money, int manualCount, int randomCount) {
        List<Lotto> manualLottos = new ArrayList<>();
        manualLottos.add(new Lotto(new ManualNumberStrategy("1,2,3,4,5,6")));
        Purchasing purchasing = new Purchasing(new Money(money), manualLottos);

        assertThat(purchasing.getManualCount()).isEqualTo(manualCount);
        assertThat(purchasing.getRandomCount()).isEqualTo(randomCount);
    }

    private static Stream<Arguments> provideLottoCount() {
        return Stream.of(
                Arguments.of("1999", 1, 0),
                Arguments.of("2000", 1, 1)
        );
    }
}
