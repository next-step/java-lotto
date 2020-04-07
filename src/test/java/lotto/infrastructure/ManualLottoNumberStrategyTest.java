package lotto.infrastructure;

import lotto.common.LottoStub;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.machine.infra.ManualLottoNumberStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static lotto.domain.Constant.LOTTO_NUM_COUNT_LIMIT;
import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoNumberStrategyTest {
    private static final int SIX = LOTTO_NUM_COUNT_LIMIT;

    @DisplayName("수동 전략을 사용하면 수동 번호를 생성할 수 있다")
    @Test
    public void manualLottoNumbersStrategyTest() {

        List<LottoNumbers> lottoNumbers = Arrays.asList(LottoStub.getLottoNumbers(1, 2, 3, 4, 5, 6));

        List<LottoNumbers> one = new ManualLottoNumberStrategy(lottoNumbers).get();
        List<LottoNumbers> another = new ManualLottoNumberStrategy(lottoNumbers).get();

        assertThat(one.get(0).getLottoNumbers()).hasSize(SIX);
        assertThat(another.get(0).getLottoNumbers()).hasSize(SIX);

        assertThat(one.equals(another)).isTrue();
    }

}
