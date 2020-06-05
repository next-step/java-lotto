package lotto;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyerTest {

    private Buyer buyer;

    @BeforeEach
    void setUp() {
        int money = 14000;
        buyer = new Buyer(money);
    }

    @Test
    void buyLottoTest() {
        buyer.buyAutoLotto();
        assertThat(buyer.getLottoCount()).isEqualTo(14);
    }

    @Test
    void checkWinLottoTest() {
        List<Integer> numberList = new ArrayList<>(List.of(1,2,3,4,5,6));
        List<Integer> winningNumberList = new ArrayList<>(List.of(1,2,3,4,5,6));
        Lotto lotto = new Lotto(numberList);
        List<Lotto> lottoList = new ArrayList<>(List.of(lotto));
        Buyer winBuyer = new Buyer(0, lottoList);
        winBuyer.checkLotto(winningNumberList);
        ArrayList<Integer> winCountList = winBuyer.checkWin();
        assertThat(winCountList.get(3)).isEqualTo(1);
    }


}
