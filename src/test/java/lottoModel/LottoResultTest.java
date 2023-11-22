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
        LottoResult lottoResult = LottoResult.result(money, lottos, lastLotto, 11);
        assertThat(lottoResult.getRateOfReturn()).isEqualTo(1.5);
    }


    @Test
    @DisplayName("2등 : 보너스 번호 당첨 번호가 마지막 게임차수 일경우 테스트")
    void second_구매금액2000원() {

        int money = 2000;
        List<Integer> lastLotto = new ArrayList(Arrays.asList(7, 18, 15, 26, 32, 1));
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(new ArrayList(Arrays.asList(1, 21, 35, 40, 41, 44)));
        Lotto lotto2 = new Lotto(new ArrayList(Arrays.asList(7, 18, 15, 26, 32, 40)));
        lottos.add(lotto1);
        lottos.add(lotto2);
        LottoResult lottoResult = LottoResult.result(money, lottos, lastLotto, 40);
        assertThat(lottoResult.getRateOfReturn()).isEqualTo(14999.0);
    }

    @Test
    @DisplayName("2등 : 보너스 번호 당첨 게임 차수가 중간 차수 일경우 : 3게임중 2번째 당첨 하였을경우 테스트")
    void second_구매금액3000원() {

        int money = 3000;
        List<Integer> lastLotto = new ArrayList(Arrays.asList(7, 18, 15, 26, 32, 1));
        List<Lotto> lottos = new ArrayList<>();
        Lotto lotto1 = new Lotto(new ArrayList(Arrays.asList(1, 21, 35, 40, 41, 44)));
        Lotto lotto2 = new Lotto(new ArrayList(Arrays.asList(7, 18, 15, 26, 32, 40)));
        Lotto lotto3 = new Lotto(new ArrayList(Arrays.asList(2, 3, 4, 6, 7, 40)));
        lottos.add(lotto1);
        lottos.add(lotto2);
        lottos.add(lotto3);
        LottoResult lottoResult = LottoResult.result(money, lottos, lastLotto, 40);
        assertThat(lottoResult.getRateOfReturn()).isEqualTo(9999.0);
    }
}
