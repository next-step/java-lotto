package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottoSellerTest {

    @DisplayName("LottoPaper 수동 로또 만큼 반환한다.")
    @Test
    void buyTest() {
        LottoPaper lottoPaper = LottoPaper.of(1, Arrays.asList("1,2,3,4,5,6"));

        LottoSeller manualLottoSeller = new ManualLottoSeller();
        Lottos buy = manualLottoSeller.lottos(lottoPaper);

        assertThat(buy.count()).isEqualTo(1);
        assertThat(buy).isEqualTo(
                Lottos.of(Arrays.asList(
                        Lotto.of("1,2,3,4,5,6")
                ))
        );
    }

}
