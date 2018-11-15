import domain.Lotto;
import domain.LottoGame;
import org.junit.Test;
import view.InputView;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    public void 로또구매() throws Exception {
        int money = 14000;
        int numberOfPurchase = InputView.numberOfPurchase(money);
        assertThat(numberOfPurchase).isEqualTo(14);
    }
    @Test
    public void 로또번호입력() throws Exception {
        String str = "1, 2, 3, 4, 5, 6";
        List<Integer> result = InputView.putWinningLotto(str);

        List<Integer> temp = new ArrayList<>();
        temp.add(1);temp.add(2);temp.add(3);temp.add(4);temp.add(5);temp.add(6);

        assertThat(result).isEqualTo(temp);
    }
    @Test(expected = Exception.class)
    public void 번호입력예외처리() throws Exception {
        String str = "1, 2, 3, 4, 5, 5";
        List<Integer> result = InputView.putWinningLotto(str);

        List<Integer> temp = new ArrayList<>();
        temp.add(1);temp.add(2);temp.add(3);temp.add(4);temp.add(5);temp.add(6);

        assertThat(result).isEqualTo(temp);
    }
}
