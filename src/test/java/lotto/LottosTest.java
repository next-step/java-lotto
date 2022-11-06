package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {
    @Test
    void 로또개수입력() {
        Lottos lottos = new Lottos(5000, 3);
        assertThat(lottos.totalQuantity()).isEqualTo(5);
        assertThat(lottos.autoLottoQuantity()).isEqualTo(2);
    }

    @Test
    void 금액을_1000원단위로_입력_안한경우() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lottos(1100, 3));
    }

    @Test
    void addLotto() {
        List<Lotto> lottoList = new ArrayList<>();
        Lotto lotto = LottoFactory.createManualLotto(Arrays.asList(1,2,3,4,5,6));
        lottoList.add(lotto);

        Lottos lottos = new Lottos(2000, 2);
        lottos.saveLotto(lottoList);
        Assertions.assertThat(lottos.getSize()).isEqualTo(1);
    }

}
