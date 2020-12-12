package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

    @DisplayName("객체생성 - 최소금액 충족")
    @Test
    void create() {
        //given
        int money = 1_000;

        //when
        LottoTickets lottoTickets = new LottoTickets(money);

        //then
        assertThat(lottoTickets).isNotNull();
    }

    @DisplayName("객체생성 - 최소금액 부족")
    @Test
    void create_lowMoney() {
        //given
        int money = 999;

        //when, then
        assertThatIllegalArgumentException()
              .isThrownBy(() -> new LottoTickets(money))
              .withMessage("금액이 부족합니다.");
    }
}
