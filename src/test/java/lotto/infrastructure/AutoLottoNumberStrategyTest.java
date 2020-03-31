package lotto.infrastructure;

import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.domain.Constant.LOTTO_NUM_COUNT_LIMIT;
import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoNumberStrategyTest {
    private static final int SIX = LOTTO_NUM_COUNT_LIMIT;

    @DisplayName("로또 번호를 자동으로 생성할 수 있다")
    @Test
    public void generateLottoNumbersTest() {
        LottoNumbers one = new AutoLottoNumberStrategy().get();
        LottoNumbers another = new AutoLottoNumberStrategy().get();

        assertThat(one.getLottoNumbers()).hasSize(SIX);
        assertThat(another.getLottoNumbers()).hasSize(SIX);

        assertThat(one.equals(another)).isFalse();
    }

}
