package step2;

import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.LottoStore;
import step2.domain.Person;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 구매갯수계산() {
        LottoStore lottoStore = new LottoStore();
        assertThat(lottoStore.getPurchaseLottoCount(14000)).isEqualTo(14);
    }

    @Test
    public void 당첨확인() {
        Person person = new Person();
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(7);
        lottoNumber.add(8);
        lottoNumber.add(9);
        Lotto lotto = new Lotto(lottoNumber);
        person.addLotto(lotto);
        int[] winNumber = new int[]{1, 2, 3, 4, 5, 6};
        int[][] winCounts = person.getWin(winNumber);

        assertThat(winCounts[0][0]).isEqualTo(1);
    }

    @Test
    public void 총수익률() {
        Person person = new Person();
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.add(1);
        lottoNumber.add(2);
        lottoNumber.add(3);
        lottoNumber.add(7);
        lottoNumber.add(8);
        lottoNumber.add(9);
        Lotto lotto = new Lotto(lottoNumber);
        person.addLotto(lotto);
        int[] winNumber = new int[]{1, 2, 3, 4, 5, 6};
        int[][] winCounts = person.getWin(winNumber);

        assertThat(person.getTotalRevenue(1000, winCounts)).isEqualTo(500.0);
    }
}
