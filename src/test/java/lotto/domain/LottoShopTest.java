package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import stringCalculator.StringCalculator;

public class LottoShopTest {

    @DisplayName("구매 금액을 티켓 금액으로 나눠 티켓 수량을 계산한다.")
    @ParameterizedTest
    @CsvSource(value = {"2000:2", "30000:30"}, delimiter = ':')
    void buy_lotto_ticket(int amount, int expected) {
        assertThat(new LottoShop().sellTicket(amount)).isEqualTo(expected);
    }

    @DisplayName("로또는 최소 한 장 이상 구해할 수 있습니다.")
    @Test
    void buy_one_or_more_ticket() {
        assertThatThrownBy(() -> new LottoShop().sellTicket(888))
            .isInstanceOf(IllegalArgumentException.class);
    }
}

