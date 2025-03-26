package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class SellerTest {

    @Test
    @DisplayName("판매자는 로또기계 하나를 가지고 있다.")
    void sellerHasLottoMachineTest() {
        var machine = new LottoTicketMachine();
        var seller = new Seller(machine);

        Assertions.assertThat(seller.hasSameMachine(machine)).isTrue();
    }

    @ParameterizedTest
    @MethodSource("sellTestData")
    @DisplayName("구매 금액을 받아 1000원당 1장으로 로또를 판매한다.")
    void sellTest(int money, int expected) {
        var seller = new Seller(new LottoTicketMachine());
        var lottos = seller.sell(money);

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
