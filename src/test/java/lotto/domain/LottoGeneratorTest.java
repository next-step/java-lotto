package lotto.domain;

import static lotto.domain.LottoGenerator.lottoGenerator;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoGeneratorTest {

    @Test
    @DisplayName("로또 자동 생성 테스트")
    void 로또_자동_생성_테스트() {
        PurchaseInfo purchasInfo = new PurchaseInfo(3000, 0);

        Lottos lottos = Lottos.createAutoLottos(purchasInfo.getNumberOfAutoPurchase(), purchaseAmount -> {
            List<Lotto> generatedLottos = new ArrayList<>();
            for (int i = 0; i < purchaseAmount; i++) {
                generatedLottos.add(new Lotto(lottoGenerator.subList(0, LottoGenerator.LOTTO_SIZE)));
            }
            return generatedLottos;
        });

        Assertions.assertThat(lottos.getNumberOfLotto()).isEqualTo(3);
    }

}

