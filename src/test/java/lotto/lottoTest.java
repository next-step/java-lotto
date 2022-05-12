package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class lottoTest {

    @Test
    void 로또를_구매하면_자동으로_번호를_생성한다() {
        Lotto lotto = new Lotto();
        assertThat(lotto.hasLottoNumber()).isTrue();
    }

    @Test
    void 로또_번호는_정렬_되어야한다() {
        Lotto lotto = new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1));
        assertThat(lotto.equals(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isTrue();
    }

    @Test
    void 지난_주_당첨_번호와_비교한다() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        assertThat(lotto.matchCount(Arrays.asList(1, 2, 3, 7, 8, 4))).isEqualTo(5);
    }

    @Test
    void 수익률을_계산해야_한다() {
        Customer customer = new Customer(14000, new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        List<Rank> winningList = customer.getWinningList( new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6), 9));
        assertThat(customer.profit(winningList)).isEqualTo(0.35);
    }

    @Test
    void _2등은_보너스_번호를_맞춰야한다() {
        Customer customer = new Customer(14000, new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        List<Rank> winningList = customer.getWinningList( new WinningNumbers(Arrays.asList(1, 2, 3, 7, 8, 0), 9));
        boolean isTwo = winningList.stream()
                .anyMatch(rank -> rank == Rank.TWO);

        assertThat(isTwo).isTrue();
    }

    @Test
    void 수동로또_구매() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9));
        Customer customer = new Customer(10000);
        customer.buy(1000, lotto);

        assertThat(customer.findLottos().contains(lotto)).isTrue();
    }
}

