package lottoTest;

import lotto.domain.Lotteries;
import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.Money;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertEquals;

public class LottoInitTest {

    @Test
    public void getCount_갯수구하기() {
        Money money = new Money(15000);
        int result = money.getTotalCount();
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void 로또숫자생성하기() {
        Lotteries lotto = new Lotteries(10);
        String[] manualLotto = new String[0];
        int result = lotto.buyLotto(manualLotto).size();
        assertThat(result).isEqualTo(10);
    }

    @Test
    public void 로또순서정렬() {
        Lotto pn = new Lotto(new HashSet<LottoNo>());
        List<Integer> params = Arrays.asList(new Integer[]{30,2,1,4,5,6});
        List<Integer> result = pn.sortNumbers(params);
        assertThat(result.get(0)).isEqualTo(1);
    }
/*
    @Test
    public void 등수구하기() {
        Rank rank = Rank.valueOf(5, false);
        assertThat(rank).isEqualTo(Rank.THIRD);
    }

    @Test
    public void 문자열로나타내기(){
        Lotto one = new Lotto(new LottoNo[]{new LottoNo(30), new LottoNo(40), new LottoNo(2), new LottoNo(14), new LottoNo(5), new LottoNo(6)});
        String result = one.toString(", ");
        assertThat(result).isEqualTo("30, 40, 2, 14, 5, 6");
    }

    @Test
    public void 값비교하기(){
        Lotto one = new Lotto(new LottoNo[]{new LottoNo(30), new LottoNo(40), new LottoNo(2), new LottoNo(14), new LottoNo(5), new LottoNo(6)});
        LottoNo no = new LottoNo(30);
        boolean result = one.isContains(no);
        assertThat(result).isEqualTo(true);

    }
    @Test
    public void 일치하는갯수_구하기() {
        WinningLotto wl = new WinningLotto("1, 2, 3, 4, 5, 6", 7);
        Lotto one = new Lotto(new LottoNo[]{new LottoNo(30), new LottoNo(40), new LottoNo(2), new LottoNo(14), new LottoNo(5), new LottoNo(6)});

        int result = wl.matchingCount(one);
        assertThat(result).isEqualTo(3);
    }*/

        @Test
        public void 총합계_구하기 () {

        }
        @Test
        public void 수익률_구하기 () {

        }

    }
