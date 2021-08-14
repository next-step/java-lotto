package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import lotto.exception.NotEnoughMoneyException;
import lotto.exception.WrongTicketCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGameVendorTest {

    @ParameterizedTest
    @MethodSource("providePurchaseOrder")
    @DisplayName("로또구입을 위해 입력된 구입정보를 통해, 자동 및 수동 로또티켓 장수가 결정된다.")
    void create_auto_and_manual_lotto_tickets(LottoPurchaseOrder order, int expectedManualCount,
        int expectedAutoCount) {
        LottoTicketBundle ticketBundle = LottoGameVendor.buyLottos(order);

        assertThat(ticketBundle.getManualTicketCount()).isEqualTo(expectedManualCount);
        assertThat(ticketBundle.getAutoTicketCount()).isEqualTo(expectedAutoCount);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, 1, 999})
    @DisplayName("로또를 1장도 살돈이 없는채로 주문을 진행할경우, 예외를 던진다.")
    void not_enough_money_for_lotto(int moneyAmount) {
        Money money = new Money(moneyAmount);
        int[][] manualNumbers = getOneManualNumberArr();
        LottoPurchaseOrder order = new LottoPurchaseOrder(money, manualNumbers);

        assertThatCode(() -> LottoGameVendor.buyLottos(order))
            .isInstanceOf(NotEnoughMoneyException.class);

    }

    @Test
    @DisplayName("로또구입을 위해 입력된 수동티켓의 수가 총구매가능 티켓의수보다 클때 예외를 던진다. ")
    void over_manual_ticket_number_inputs() {
        Money money = new Money(1000);
        int[][] manualNumbers = new int[][]{{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}};
        LottoPurchaseOrder order = new LottoPurchaseOrder(money, manualNumbers);

        assertThatThrownBy(() -> LottoGameVendor.buyLottos(order))
            .isInstanceOf(WrongTicketCountException.class);

    }


    private static Stream<Arguments> providePurchaseOrder() {

        return Stream.of(
            Arguments.of(new LottoPurchaseOrder(new Money(3000), getEmptyManualNumberArr()), 0, 3),
            Arguments.of(new LottoPurchaseOrder(new Money(3000), getOneManualNumberArr()), 1, 2),
            Arguments.of(new LottoPurchaseOrder(new Money(3500), getTwoManualNumberArr()), 2, 1),
            Arguments.of(new LottoPurchaseOrder(new Money(3999), getThreeManualNumberArr()), 3, 0)
        );
    }

    private static int[][] getEmptyManualNumberArr() {
        return new int[][]{};
    }

    private static int[][] getOneManualNumberArr() {
        return new int[][]{{1, 2, 3, 4, 5, 6}};
    }

    private static int[][] getTwoManualNumberArr() {
        return new int[][]{{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}};
    }

    private static int[][] getThreeManualNumberArr() {
        return new int[][]{{1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15, 16, 17, 18}};
    }

}