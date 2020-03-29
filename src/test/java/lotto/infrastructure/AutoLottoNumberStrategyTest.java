package lotto.infrastructure;

import lotto.domain.LottoTicket;
import lotto.infrastructure.AutoLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.Constant.*;
import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoNumberStrategyTest {

    private static final int SIX = LOTTO_NUM_COUNT_LIMIT;

    @DisplayName("로또 번호를 자동으로 생성할 수 있다")
    @Test
    public void generateLottoNumbersTest() {
        LottoTicket one = new AutoLottoNumberStrategy().get();
        LottoTicket another = new AutoLottoNumberStrategy().get();

        System.out.println(one);
        System.out.println(another);

        assertThat(one.size()).isEqualTo(SIX);
        assertThat(another.size()).isEqualTo(SIX);

        assertThat(one.equals(another)).isFalse();
    }

}
