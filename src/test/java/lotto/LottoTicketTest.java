package lotto;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketTest {

    @Test
    @DisplayName("구매한 로또 개수 구하기")
    void 구매_로또_개수_계산() {
        int money = 14000;
        LottoTicket lotto = new LottoTicket(money);

        assertThat(lotto.getCount()).isEqualTo(14);
    }

    @ParameterizedTest
    @DisplayName("로또를 한장 이상 구매하여야합니다")
    @ValueSource(ints = {999,-1000})
    void 로또_한장_이상_구매(int input) {

        assertThatThrownBy(() -> new LottoTicket(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("로또를 한장 이상 구매하여야합니다");

    }

}