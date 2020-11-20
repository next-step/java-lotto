package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PrizeWinningResultTest {

    @DisplayName("구입금액이 0원 이하면 exception 이 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void exception(int paidMoney){
        assertThatThrownBy(() -> PrizeWinningResult.builder().paidMoney(paidMoney))
                .isInstanceOf(PrizeWinningResultBulderException.class);
    }

}