package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.domain.LottoCount;
import lotto.domain.ManualLottoCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ManualLottoCountTest {
    LottoCount totalLottoCount = LottoCount.from(10);

    @DisplayName("범위를 넘어가는 수동 로또 개수에 대해서 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 11, 12})
    void validateManualLottoCount(int input) {

        assertThatIllegalArgumentException().isThrownBy(() -> ManualLottoCount.of(input, totalLottoCount));

        assertThatCode(() -> ManualLottoCount.of(1, totalLottoCount))
                .doesNotThrowAnyException();
    }

    @Test
    void calculateAutoLottoCountByTotalCount() {
        ManualLottoCount manualLottoCount = ManualLottoCount.of(3, totalLottoCount);
        assertThat(manualLottoCount.calculateAutoLottoCount(totalLottoCount))
                .isEqualTo(7);
    }
}
