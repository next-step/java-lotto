package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StoreTest {

    @Test
    @DisplayName("상점에서 돈 입력했을 경우 로또티켓 생성 테스트")
    void lottoCreateTest() {
        Store store = new Store("3000");
        LottoTicket lottoTicket = store.purchaseTicket();

        assertThat(lottoTicket.getLotto().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("예외 검증(숫자가 아닌 문자를 입력 했을 경우)")
    void exceptionTest() {

        assertThatThrownBy(() ->
                new Store("String Input")).isInstanceOf(IllegalArgumentException.class);
    }
}
