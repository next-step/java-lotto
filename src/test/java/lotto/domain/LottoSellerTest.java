package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoSellerTest {

    @DisplayName("입력한 돈만큼 로또 구매")
    @ParameterizedTest
    @CsvSource({"1500,1", "2000,2"})
    void buy(int money, int expected) {
        List<Lotto> buy = LottoSeller.buy(money);
        assertThat(buy.size()).isEqualTo(expected);
    }

    @DisplayName("천원 미만으로 로또 구매시 에러")
    @Test
    void buyFail() {
        assertThatCode(() -> LottoSeller.buy(1000)).doesNotThrowAnyException();
        assertThatIllegalArgumentException().isThrownBy(() -> LottoSeller.buy(900));
    }

    @Test
    void match() {
    }

}