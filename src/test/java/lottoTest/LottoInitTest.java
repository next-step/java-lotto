package lottoTest;

import lotto.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.Assert.assertEquals;

public class LottoInitTest {

    @Test
    public void getCount_갯수구하기() {
        LottoInit cost = new LottoInit(15000);
        int result = cost.getTotalCount();
        assertThat(result).isEqualTo(15);
    }

    @Test
    public void 로또숫자생성하기() {
        LottoInit init = new LottoInit(15000);
        Lotteries lotto = new Lotteries(init);
        int result = lotto.buyLotto().size();
        assertThat(result).isEqualTo(14);
    }

    @Test
    public void 로또순서정렬() {
        Lotto pn = new Lotto();
        List<LottoNo> params = Arrays.asList(new LottoNo[]{new LottoNo(30), new LottoNo(40), new LottoNo(2), new LottoNo(14), new LottoNo(5), new LottoNo(6)});
        List<LottoNo> result = pn.sortNumbers(params);
        assertThat(result.get(0).getNumber()).isEqualTo(2);
    }

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
  /*  @Test
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
