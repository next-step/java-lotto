package lotto.automatic.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class ManualLottosTest {

    @Test
    void getManualLottos() {

        ManualLottos lottos = new ManualLottos(1, Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"));

        int manualAmount = lottos.getManualAmount();
        assertThat(manualAmount).isEqualTo(1);
    }

    @Test
    void getLottoCollectionSize() {

        ManualLottos lottos = new ManualLottos(1, Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"));

        int size = lottos.getLottos().size();
        assertThat(size).isEqualTo(2);
    }

    @Test
    @DisplayName("전체_로또수와_수동_수_비교")
    void validateLottoManualAmount() {

        ManualLottos.validateManualLottoCountWithTotalCount(4, 1);

        assertThatIllegalArgumentException()
            .isThrownBy(() -> ManualLottos.validateManualLottoCountWithTotalCount(3, 4));

    }

    @Test
    @DisplayName("수동_로또_갯수가_음수면_exception")
    void 수동_로또_카운트가_음수인_경우() {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    new ManualLottos(-1, Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"));
                }
        );

    }

}