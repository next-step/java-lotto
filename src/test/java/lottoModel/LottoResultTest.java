package lottoModel;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    @DisplayName("로또 수익률 계산")
    void result() {

        int money = 2000;
        List<Integer> lastLotto = new ArrayList(Arrays.asList(4, 5, 6, 15, 16, 17));
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6)));
        Lotto lotto2 = new Lotto(new ArrayList(Arrays.asList(6, 7, 8, 9, 10, 11)));
        lottos.add(lotto1);
        lottos.add(lotto2);
        LottoResult lottoResult = LottoResult.result(money, lottos, lastLotto);
        assertThat(lottoResult.getRateOfReturn()).isEqualTo(1.5);
    }
}
