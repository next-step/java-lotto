package domain;

import org.junit.Before;
import org.junit.Test;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;
public class LottoGameTest {
    List<Lotto> lottos = new ArrayList<>();
    List<Integer> numbers = new ArrayList<>();
    Lotto lastLotto;
    int price = 0;
    int totalRewards = 0;


    @Before
    public void setUp()  {
        numbers = Arrays.asList(1,2,3,4,5,6);
        lastLotto = new Lotto(numbers);
        lottos = Arrays.asList(lastLotto, lastLotto, lastLotto);
        price = 14000;
        totalRewards = 5000;
    }

    @Test
    public void 로또가격만큼산개수() {
        price = 14000;
        List<Lotto> buyLottos = InputView.buyLottoCount(price);
        assertThat(buyLottos).hasSize(14);
    }


    @Test
    public void 당첨된로또목록() {
        List<Integer> diffNum = Arrays.asList(8,9,10,11,12,13);
        Lotto diffLotto = new Lotto(diffNum);

        lottos = Arrays.asList(lastLotto, lastLotto, lastLotto);

        assertThat(new LottoGame(lottos, diffLotto).getCombineLottos()).hasSize(0);

        assertThat(new LottoGame(lottos, lastLotto).getCombineLottos()).isEqualTo(lottos);
    }

    @Test
    public void 총수입률() {
        double result = ResultView.totalEarningRate(price,totalRewards);
        assertThat(result).isEqualTo(((double)5000/(double)14000));
    }

    @Test
    public void winCalculate(){
        lastLotto = new Lotto(numbers);
        List<Lotto> lottos =  Arrays.asList(lastLotto, lastLotto, lastLotto);
        LottoGame lottoGame  = new LottoGame(lottos, lastLotto);
        int[] combineNumbers = lottoGame.winCalculate();
        assertThat(combineNumbers[6]).isEqualTo(3);
        assertThat(combineNumbers[5]).isEqualTo(0);
    }

    @Test
    public void getCombineCount(){
        List<Integer> numbers2 = Arrays.asList(1,2,3,4,5,7);
        Lotto originLotto = new Lotto(numbers);
        Lotto lastLotto = new Lotto(numbers2);
        int combineCount = originLotto.getCombineCount(lastLotto);
        assertThat(combineCount).isEqualTo(5);
    }

}