package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoBuyMethodTest {

    private final int lottoPrice = LottoBuyMethod.LOTTO_PRICE;
    private final int money = 14000;
    private final int totalCount = money / lottoPrice;
    private final List<String> manualNumbers = Arrays.asList(
            "1, 2, 3, 4, 5, 6",
            "7, 8, 9, 10, 11, 12");
    private final int manualCount = 2;
    private final int autoCount = totalCount - manualCount;

    private final LottoBuyMethod buyMethod = new LottoBuyMethod(money, manualNumbers);

    @DisplayName("구입금액, 수동 구매 개수로 구매 방법 결정")
    @Test
    void create() {
        assertThat(buyMethod).isEqualTo(new LottoBuyMethod(money, manualNumbers));
    }

    @DisplayName("구매 가능한 금액 입력")
    @Test
    void create_enough_monery() {
        int money = lottoPrice;
        assertDoesNotThrow(() -> new LottoBuyMethod(money, new ArrayList<>()));
    }

    @DisplayName("구매 불가능한 금액 입력_로또 금액 미만")
    @Test
    void create_not_enough_money_fail() {
        int money = lottoPrice - 1;
        assertThatThrownBy(() -> new LottoBuyMethod(money, new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("해당 금액으로는 로또를 사실 수 없습니다.");
    }

    @DisplayName("구매 금액을 수동 구매 개수가 초과")
    @Test
    void create_over_manual_count_fail() {
        int availablePrice = lottoPrice * manualNumbers.size();
        int notAvailablePrice = lottoPrice * manualNumbers.size() - 1;

        assertDoesNotThrow(() -> new LottoBuyMethod(availablePrice, manualNumbers));
        assertThatThrownBy(() -> new LottoBuyMethod(notAvailablePrice, manualNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("구매 개수보다 수동으로 더 많이 살 수 없습니다.");
    }

    @DisplayName("총 구매 개수 확인")
    @Test
    void getBuyCountTotal() {
        assertThat(buyMethod.getBuyCountTotal()).isEqualTo(totalCount);
    }

    @DisplayName("수동 구매 개수 확인")
    @Test
    void getManualCount() {
        assertThat(buyMethod.getManualCount()).isEqualTo(manualCount);
    }

    @DisplayName("자동 구매 개수 확인")
    @Test
    void getAutoCount() {
        assertThat(buyMethod.getAutoCount()).isEqualTo(autoCount);
    }

}
