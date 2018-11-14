package lottoTest;

import lotto.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoInitTest {

    @Test
    public void getCount_갯수구하기(){
        LottoInit cost = new LottoInit(15000);
        int result = cost.getCount();
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void 로또숫자생성하기(){
        Lotteries lotto = new Lotteries(14);
        int result = lotto.buyLotto().size();
        assertThat(result).isEqualTo(14);
    }

    @Test
    public void 로또순서맞추기(){
        Lotto pn = new Lotto();
        List<Integer> params = Arrays.asList(new Integer[]{30,40,2,14,5,6});
        List<Integer> result = pn.sortNumbers(params);
        assertThat(result).isEqualTo(Arrays.asList(new Integer[]{2,5,6,14,30,40}));
    }
/*
    @Test
    public void 로또당첨숫자비교하기(){
        Scanner sc = new Scanner(System.in);
        System.out.println("입력: ");
        String list = sc.next();
        LottoCompare lr = new LottoCompare(list);

        List<Integer> params = Arrays.asList(new Integer[]{30,40,2,14,5,6});
        int result = lr.compareNumber(params);
        assertThat(result).isEqualTo(3);

    }

    @Test
    public void 총합계구하기(){
        LottoResult lr = new LottoResult(new int[]{10,3,1,0,0,0});
        assertThat(lr.getTotalSum()).isEqualTo(5000);
    }
    @Test
    public void 수익률구하기(){
        LottoResult lr = new LottoResult(new int[]{10,3,1,0,0,0});
        double rate = lr.calculateRate(5000, 14000);
        assertThat(Math.floor(rate*100)/100.0).isEqualTo(0.35);
    }*/

}
