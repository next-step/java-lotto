package lotto.infrastructure;

import lotto.domain.lotto.LottoNumbers;
import lotto.domain.machine.infra.AutoLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.domain.Constant.LOTTO_NUM_COUNT_LIMIT;
import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoNumberStrategyTest {
    private static final int SIX = LOTTO_NUM_COUNT_LIMIT;

    @DisplayName("로또 번호를 자동으로 생성할 수 있다")
    @Test
    public void generateLottoNumbersTest() {
        List<LottoNumbers> one = new AutoLottoNumberStrategy(1).get();
        List<LottoNumbers> another = new AutoLottoNumberStrategy(1).get();

        assertThat(one.get(0).getLottoNumbers()).hasSize(SIX);
        assertThat(another.get(0).getLottoNumbers()).hasSize(SIX);

        assertThat(one.equals(another)).isFalse();
    }

}
