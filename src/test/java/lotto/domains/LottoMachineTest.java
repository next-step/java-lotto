package lotto.domains;

import lotto.enums.PurchasingWay;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @Test
    void 구입정보를_이용하여_로또컬렉션_반환_테스트() {
        List<String> manualLottos = new ArrayList<>();
        manualLottos.add("1,2,3,4,5,6");
        manualLottos.add("11,12,13,14,15,16");
        manualLottos.add("21,22,23,24,25,26");
        PurchasingInfo purchasingInfo = new PurchasingInfo(14000, manualLottos);
        Lottos lottos = LottoMachine.makeLottos(purchasingInfo);
        assertThat(lottos.countOfPurchasingWay(PurchasingWay.MANUAL)).isEqualTo(3);
        assertThat(lottos.countOfPurchasingWay(PurchasingWay.AUTOMATIC)).isEqualTo(11);
    }
}
