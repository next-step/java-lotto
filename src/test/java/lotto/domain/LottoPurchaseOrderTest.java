package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoPurchaseOrderTest {


    @Test
    @DisplayName("로또구입시의 필요정보를 전달하기 위한 구입정보객체를 생성할수있다.")
    void create_lotto_purchase_order() {
        Money gameMoney = new Money(2000);
        int[][] manualLottoNumbers = {{1, 2, 3, 4, 5, 6,}, {7, 8, 9, 10, 11, 12}};

        assertThatCode(() -> new LottoPurchaseOrder(gameMoney, manualLottoNumbers))
            .doesNotThrowAnyException();

    }

    @ParameterizedTest
    @MethodSource("ttt")
    @DisplayName("로또구입시의 필요정보를 전달하기 위한 구입정보객체를 생성할수있다.")
    void create_different_lotto_purchase_orders(Money money, int[][] inputManualNumbers,
        Money expectedMoney, TicketCount expectedCount) {

        LottoPurchaseOrder order = new LottoPurchaseOrder(money, inputManualNumbers);

        assertThat(order.getGameMoney()).isEqualTo(expectedMoney);
        assertThat(order.getManualLottoTicketCount()).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> ttt() {
        return Stream.of(
            Arguments.of(new Money(100), new int[][]{},
                new Money(100), new TicketCount(0)),
            Arguments.of(new Money(1000), new int[][]{{1, 2, 3, 4, 5, 6,}},
                new Money(1000), new TicketCount(1)),
            Arguments.of(new Money(2000), new int[][]{{1, 2, 3, 4, 5, 6,}, {7, 8, 9, 10, 11, 12}},
                new Money(2000), new TicketCount(2))
        );
    }


}