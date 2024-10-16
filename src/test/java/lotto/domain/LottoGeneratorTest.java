package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoGenerator.lottoGenerator;

public class LottoGeneratorTest {
    @Test
    @DisplayName("로또 생성 테스트")
    void 로또_생성_테스트() {
        Lottos lottos = Lottos.createLottos(3000, purchaseAmount -> {
            List<Lotto> generatedLottos = new ArrayList<>();
            for (int i = 0; i < purchaseAmount / LottoGenerator.PRICE_OF_LOTTO; i++) {
                generatedLottos.add(new Lotto(lottoGenerator.subList(0, LottoGenerator.LOTTO_SIZE)));
            }
            return generatedLottos;
        });

        Assertions.assertThat(lottos.getNumberOfLotto()).isEqualTo(3);
    }
}
