package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoSellerTest {

    @DisplayName("입력한 만큼 로또 구매")
    @Test
    void buy() {
        List<Object> buy = LottoSeller.buy(5);
        assertThat(buy.size()).isEqualTo(5);
    }

    @DisplayName("1개 미만 로또 구매시 에러")
    @Test
    void buyFail() {
        assertThatCode(() -> LottoSeller.buy(1)).doesNotThrowAnyException();
        assertThatIllegalArgumentException().isThrownBy(() -> LottoSeller.buy(0));
    }

    @Test
    void match() {
    }

}