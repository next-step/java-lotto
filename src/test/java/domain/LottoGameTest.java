package domain;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    List<Lotto> lottoList = new ArrayList<>();
    Lottos lottos;
    List<Integer> numbers = new ArrayList<>();
    Lotto lastLotto;
    int price = 0;
    int totalRewards = 0;


    @Before
    public void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        lastLotto = new Lotto(numbers);
        lottoList = Arrays.asList(lastLotto, lastLotto, lastLotto);
        lottos = new Lottos(lottoList);
        price = 14000;
        totalRewards = 5000;
    }

    @Test
    public void 로또가격만큼산개수() {
        Lottos buyLottos = new Lottos(14);
        assertThat(buyLottos.size()).isEqualTo(14);
    }


    @Test
    public void 당첨된로또목록() {
        Lottos cobineLottos = lottos.getCombineLottos(lastLotto);
        assertThat(cobineLottos.size()).isEqualTo(3);
        assertThat(cobineLottos.isContain(lastLotto)).isTrue();
    }

    @Test
    public void 당첨안된로또목록() {
        List<Integer> diffNum = Arrays.asList(7, 8, 9, 10, 11, 12);
        Lotto diff = new Lotto(diffNum);
        Lottos cobineLottos = lottos.getCombineLottos(diff);

        assertThat(cobineLottos.size()).isEqualTo(0);
        assertThat(cobineLottos.isContain(diff)).isFalse();
    }

    @Test
    public void 총수입률() {
        double result = LottoGame.getTotalEarningRate(price, totalRewards);
        assertThat(result).isEqualTo(((double) 5000 / (double) 14000));
    }

    @Test
    public void 당첨개수테스트() {
        lastLotto = new Lotto(numbers);
        int[] combineNumbers = new int[7];
        for (Lotto lotto : lottoList) {
            combineNumbers[lotto.getCombineCount(lastLotto)]++;
        }
        assertThat(combineNumbers[6]).isEqualTo(3);
    }

    @Test
    public void 미당첨개수테스트() {
        List<Integer> diffNum = Arrays.asList(7, 8, 9, 10, 11, 12);
        Lotto diff = new Lotto(diffNum);
        int[] combineNumbers = new int[7];
        for (Lotto lotto : lottoList) {
            combineNumbers[lotto.getCombineCount(diff)]++;
        }
        assertThat(combineNumbers[0]).isEqualTo(3);
    }

    @Test
    public void getTotalRewards() {
        lottos.calculateCombine(lastLotto);
        int rewards = lottos.getTotalRewards();
        assertThat(rewards).isEqualTo(2_000_000_000 * 3);
    }

    @Test
    public void getTotalEarningRate() {
        double earningRate = LottoGame.getTotalEarningRate(14000, 5000);
        assertThat(earningRate).isEqualTo((double) (5000) / (double) 14000);
    }
}
