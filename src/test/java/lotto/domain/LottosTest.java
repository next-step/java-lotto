package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.LottoFixture.lottoFixture;
import static lotto.domain.LottoFixture.lottoNumbersFixture;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottosTest {
    @Test
    void 전체자동발급() {
        MyPurchase myPurchase = new MyPurchase(11000);
        Lottos lottos = Lottos.create(myPurchase, null);
        assertAll(
                () -> assertThat(lottos.size()).isEqualTo(11),
                () -> assertThat(lottos.getAutoLottos().size()).isEqualTo(myPurchase.autoCount())
        );
    }

    @Test
    void 전체수동발급() {
        MyPurchase myPurchase = new MyPurchase(3000,3);
        List<LottoNumbers> manualNumbers = new ArrayList<>();

        manualNumbers.add(lottoNumbersFixture(List.of(1, 2, 3, 4, 5, 6)));
        manualNumbers.add(lottoNumbersFixture(List.of(11, 12, 13, 14, 15, 16)));
        manualNumbers.add(lottoNumbersFixture(List.of(21, 22, 23, 24, 25, 26)));

        Lottos lottos = Lottos.create(myPurchase, manualNumbers);
        assertAll(
                () -> assertThat(lottos.getManualLottos().get(0)).isEqualTo(lottoFixture(List.of(1, 2, 3, 4, 5, 6))),
                () -> assertThat(lottos.getManualLottos().size()).isEqualTo(3),
                () -> assertThat(lottos.getManualLottos().size()).isEqualTo(myPurchase.manualCount())
        );
    }

    @Test
    void 자동수동함께발급() {
        MyPurchase myPurchase = new MyPurchase(5000,3);
        List<LottoNumbers> manualNumbers = new ArrayList<>();

        manualNumbers.add(lottoNumbersFixture(List.of(1, 2, 3, 4, 5, 6)));
        manualNumbers.add(lottoNumbersFixture(List.of(11, 12, 13, 14, 15, 16)));
        manualNumbers.add(lottoNumbersFixture(List.of(21, 22, 23, 24, 25, 26)));

        Lottos lottos = Lottos.create(myPurchase, manualNumbers);

        assertAll(
                () -> assertThat(lottos.size()).isEqualTo(5),
                () -> assertThat(lottos.getManualLottos().get(0)).isEqualTo(lottoFixture(List.of(1, 2, 3, 4, 5, 6)))
        );
    }
}
