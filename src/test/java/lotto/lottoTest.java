package lotto;

import lotto.domain.Customer;
import lotto.domain.Lotto;
import lotto.domain.Revenue;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class lottoTest {

    @Test
    void 로또를_구매한다() {
        Customer customer = new Customer(14000);
        customer.buy(1000);
        assertThat(customer.balanceCheck(13000)).isTrue();
    }

    @Test
    void 로또를_구매하면_자동으로_번호를_생성한다() {
        Lotto lotto = new Lotto();
        assertThat(lotto.size()).isEqualTo(6);
    }

    @Test
    void 로또_번호는_정렬_되어야한다() {
        Lotto lotto = new Lotto(Arrays.asList(6, 5, 4, 3, 2, 1));
        assertThat(lotto.equals(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isTrue();
    }

    @Test
    void 지난_주_당첨_번호와_비교한다() {
        Customer customer = new Customer(1000, new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        assertThat(customer.compareTo(Arrays.asList(1, 2, 3, 4, 5, 6)).size()).isEqualTo(1);
    }

    @Test
    void 수익률을_계산해야_한다() {
        Customer customer = new Customer(1000, new Lotto(Arrays.asList(1, 2, 3, 7, 8, 9)));
        List<List<Integer>> lottos = customer.compareTo(Arrays.asList(1, 2, 3, 4, 5, 6));

    }
}

