package domain;

import org.junit.Before;
import org.junit.Test;
import utils.StringUtils;
import view.InputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;

public class LottoGroupTest {
    LottoGroup lottoGroup;
    Lotto lastLotto;


    @Before
    public void setUp() {
        lastLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        lottoGroup = new LottoGroup(Arrays.asList(lastLotto, lastLotto, lastLotto));
    }

    @Test
    public void 로또가격만큼산개수() {
        LottoGroup buyLottoGroup = new LottoGroup(14);
        assertThat(buyLottoGroup.getSize()).isEqualTo(14);
    }

    @Test
    public void 총수입률() {
        int price = 14000;
        int totalRewards = 5000;
        double result = LottoGame.getTotalEarningRate(price, totalRewards);
        assertThat(result).isEqualTo(((double) 5000 / (double) 14000));
    }

    @Test
    public void 당첨개수테스트() {
        List<Lotto> lottoList = Arrays.asList(lastLotto, lastLotto, lastLotto);
        Lotto lastLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int[] combineNumbers = new int[7];
        for (Lotto lotto : lottoList) {
            combineNumbers[lotto.getCombineCount(lastLotto)]++;
        }
        assertThat(combineNumbers[6]).isEqualTo(3);
    }

    @Test
    public void 미당첨개수테스트() {
        List<Lotto> lottoList = Arrays.asList(lastLotto, lastLotto, lastLotto);
        List<Integer> diffNum = Arrays.asList(7, 8, 9, 10, 11, 12);
        Lotto diff = new Lotto(diffNum);
        int[] combineNumbers = new int[7];
        for (Lotto lotto : lottoList) {
            combineNumbers[lotto.getCombineCount(diff)]++;
        }
        assertThat(combineNumbers[0]).isEqualTo(3);
    }


    @Test
    public void 수동로또하기() {

        int buyManualLottoCount = 3;
        List<Lotto> lottoList = Arrays.asList(lastLotto, lastLotto, lastLotto);
        List<Lotto> lottoList1 = Arrays.asList(lastLotto, lastLotto, lastLotto);
//        for(int i =0; i < buyManualLottoCount; i++){
//            lottoList.add(new Lotto(StringUtils.convertStrToNum(InputView.lastLottoNumber())));
//        }
        lottoList.addAll(lottoList1);
        LottoGroup lottoGroup = new LottoGroup(lottoList, lottoList1);
//        lottoGroup.add(manualLottoGroup);




        assertThat(lottoList.size()).isEqualTo(lottoGroup.getSize());
    }
}
