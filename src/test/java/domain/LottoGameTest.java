package domain;

import org.junit.Before;
import org.junit.Test;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;
public class LottoGameTest {
    List<Lotto> lottos = new ArrayList<>();
    List<Integer> numbers = new ArrayList<>();
    List<Integer> numbers2 = new ArrayList<>();
    Lotto lastLotto;
    Lotto lastLotto2;
    int price = 0;
    int totalRewards = 0;

    @Before
    public void setUp() throws Exception {
        numbers = Arrays.asList(1,2,3,4,5,6);
        numbers2 = Arrays.asList(1,2,7,4,5,6);
        lastLotto = new Lotto(numbers);
        lastLotto2 = new Lotto(numbers2);
        lottos = Arrays.asList(lastLotto, lastLotto, lastLotto2);
        price = 14000;
        totalRewards = 5000;
    }

    @Test
    public void 로또가격만큼산개수() {
        price = 14000;
        List<Lotto> buyLottos = InputView.buyLottoCount(price);
        assertThat(buyLottos.size()).isEqualTo(14);
    }


    @Test
    public void 당첨된로또목록() {
        numbers = Arrays.asList(1,2,3,4,5,6);
        numbers2 = Arrays.asList(1,2,7,4,5,6);
        List<Integer> diffNum = Arrays.asList(8,9,10,11,12,13);
        lastLotto = new Lotto(numbers);
        lastLotto2 = new Lotto(numbers2);
        Lotto diffLotto = new Lotto(diffNum);
        lottos = Arrays.asList(lastLotto, lastLotto, lastLotto2);


        List<Lotto> combineLottos = ResultView.winStats(lottos, diffLotto);
        assertThat(combineLottos.size()).isEqualTo(0);

        combineLottos = ResultView.winStats(lottos, lastLotto);
        assertThat(combineLottos.size()).isEqualTo(3);


    }

    @Test
    public void 총수입률() {
        price = 14000;
        totalRewards = 5000;
        double result = ResultView.totalEarningRate(price,totalRewards);
        assertThat(result).isEqualTo(((double)5000/(double)14000));
    }
    @Test
    public void winCalculate(){
        numbers = Arrays.asList(1,2,3,4,5,6);
        numbers2 = Arrays.asList(1,2,7,4,5,6);
        lastLotto = new Lotto(numbers);
        lastLotto2 = new Lotto(numbers2);
        List<Lotto> lottos =  Arrays.asList(lastLotto, lastLotto, lastLotto2);
        int[] combineNumbers = new int[7];
        for(Lotto lotto : lottos){
            combineNumbers[lotto.getCombineCount(lastLotto)]++;
        }
        assertThat(combineNumbers[6]).isEqualTo(2);
        assertThat(combineNumbers[5]).isEqualTo(1);
    }
    @Test
    public void getCombineCount(){
        numbers = Arrays.asList(1,2,3,4,5,6);
        numbers2 = Arrays.asList(1,2,7,4,5,6);
        lastLotto = new Lotto(numbers);
        lastLotto2 = new Lotto(numbers2);
        Lotto originLotto = new Lotto(numbers);
        Lotto lastLotto = new Lotto(numbers2);
        List<Integer> numbers = originLotto.getNumbers();
        int combineCount = (int)numbers.stream()
                .filter(obj->lastLotto.getNumbers().contains(obj))
                .count();

        assertThat(combineCount).isEqualTo(5);
    }

}