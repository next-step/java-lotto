package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StoreTest {

    @Test
    @DisplayName("상점에서 돈 입력했을 경우 로또티켓 생성 테스트")
    void lottoCreateTeset() {
        Store store = Store.of("3000");

        assertThat(store.getLottoTicket().getLottoNumber().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("예외 검증(1000원 이하 입력했을 경우, 숫자가 아닌 문자를 입력 했을 경우)")
    void exceptionTest() {
        assertThatThrownBy(() ->
                Store.of("500")).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->
                Store.of("String Input")).isInstanceOf(IllegalArgumentException.class);
    }
}
