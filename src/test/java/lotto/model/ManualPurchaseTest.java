package lotto.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static lotto.model.LottoFactory.create;
import static org.assertj.core.api.Assertions.assertThat;

class ManualPurchaseTest {

    @Test
    void 수동구매_요청수량이_0인경우_빈배열을_반환한다() {
        LottoMachine machine = new ManualPurchase();
        List<Lotto> lottos = machine.purchase(0, Collections.emptyList());

        assertThat(lottos).isEmpty();
    }

    @Test
    void 수동구매번호_문자열로_로또생성하여_반환한다() {
        List<String> manualLotto = Arrays.asList("8, 21, 23, 41, 42, 43", "3, 5, 11, 16, 32, 38", "7, 11, 16, 35, 36, 44");

        LottoMachine machine = new ManualPurchase();
        List<Lotto> lottos = machine.purchase(manualLotto.size(), manualLotto);

        assertThat(lottos).hasSize(3)
                .containsExactly(create(8, 21, 23, 41, 42, 43), create(3, 5, 11, 16, 32, 38), create(7, 11, 16, 35, 36, 44));
    }

}
