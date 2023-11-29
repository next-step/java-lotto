package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoPurchaseInfoTest {

    @DisplayName("구매 금액을 티켓 금액으로 나눠 티켓 수량을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"2000:2", "30000:30"}, delimiter = ':')
    void buy_lotto_ticket(int amount, int expected) {
        assertThat(new LottoPurchaseInfo(amount, 0).calcTotalQuantity()).isEqualTo(expected);
    }

    @DisplayName("로또는 최소 한 장 이상 구해할 수 있습니다.")
    @Test
    void buy_one_or_more_ticket() {
        assertThatThrownBy(() -> new LottoPurchaseInfo(888, 0))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("수동 구매 개수가 총 구매 개수 보다 많을 시 IllegalArgumentException을 던진다. (자동 구매 개수는 0개 이상이어야 한다)")
    @Test
    void total_is_greater_than_manual() {
        assertThatThrownBy(() -> new LottoPurchaseInfo(3000, 4))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

