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
        List<Lotto> automaticLottoList = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            automaticLottoList.add(Lotto.of("1,2,3,4,5,6"));
        }
        Lottos lottos = new Lottos(new ArrayList<>(), automaticLottoList);
        assertThat(lottos.getLottos().size()).isEqualTo(purchaseQuantity);
    }

    @Test
    @DisplayName("로또 자동+수동 구매 성공 테스트")
    void 로또_자동_수동_구매_성공_테스트() {
        List<Lotto> manualLottoList = new ArrayList<>(Arrays.asList(Lotto.of("1,2,3,4,5,6")));
        List<Lotto> automaticLottoList = new ArrayList<>(Arrays.asList(Lotto.of("1,2,3,4,5,6"), Lotto.of("7,8,9,10,11,12")));
        Lottos lottos = new Lottos(manualLottoList, automaticLottoList);
        assertThat(lottos.getLottos().size()).isEqualTo(3);
    }
}
