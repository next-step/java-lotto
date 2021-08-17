package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @ParameterizedTest
    @DisplayName("로또 자동 구매 성공 테스트")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void 로또_자동_구매_성공_테스트(int purchaseQuantity) {
        Lottos lottos = new Lottos(purchaseQuantity, new ArrayList<>());
        assertThat(lottos.getLottos()
                         .size()).isEqualTo(purchaseQuantity);
    }

    @Test
    @DisplayName("로또 자동+수동 구매 성공 테스트")
    void 로또_자동_수동_구매_성공_테스트() {
        List<Lotto> manualLottoList = new ArrayList<>(Arrays.asList(Lotto.of("1,2,3,4,5,6")));
        Lottos lottos = new Lottos(5, manualLottoList);
        assertThat(lottos.getLottos().size()).isEqualTo(5);
        assertThat(lottos.getManualLottoQuantity()).isEqualTo(1);
    }
}
