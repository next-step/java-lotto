package AutoLotto.domain.money;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BuzzMoneyTest {

    @Test
    void canCreateAllMoney() {

        List<BuzzMoney> bList = Arrays.asList(BuzzMoney.Hit3, BuzzMoney.Hit4, BuzzMoney.Hit5, BuzzMoney.Hit6);
        List<Integer> hList = Arrays.asList(1,1,2,0,3,1,2,1);
        assertThat(BuzzMoney.createAllMoney(bList, hList)).isEqualTo(5000);
    }
}
