package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class ManualLottoTest {

    @Test
    void 수동_로또_번호는_중복되선_안된다() {
        assertThatThrownBy(() -> new ManualLotto(
            Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(5))));
    }

    @Test
    void 수동_로또_번호를_저장한다() {
        ManualLotto manualLotto = new ManualLotto(
            Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        List<Lotto> manualLottos = new ArrayList<>();
        manualLottos = manualLotto.addManualLotto(manualLottos);
        assertThat(manualLottos).containsExactly(
            new Lotto(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))));
    }
}