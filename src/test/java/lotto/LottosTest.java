package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    public void 구매금액에_대한_로또_리스트_생성() {
        Lottos lottos = new Lottos(14000);
        assertThat(lottos.lottosSize()).isEqualTo(14);
    }

    @Test
    public void 당첨번호_통계() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 20)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 15, 20)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 14, 15, 20)));

        Lottos lottos = new Lottos(lottoList);
        Lotto winning = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Map<Integer, Integer> result = lottos.getResult(winning);

        assertThat(result.get(3)).isEqualTo(1);
        assertThat(result.get(4)).isEqualTo(1);
        assertThat(result.get(5)).isEqualTo(2);
        assertThat(result.get(6)).isEqualTo(1);
    }

    @Test
    public void 수익률_구하기() {
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 20)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 20)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 15, 20)));
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 14, 15, 20)));

        Lottos lottos = new Lottos(lottoList);
        Lotto winning = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottos.getResult(winning);

        assertThat(lottos.getProfitRate()).isEqualTo(0.4);
    }
}
