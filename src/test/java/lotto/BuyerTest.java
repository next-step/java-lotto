package lotto;

import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoNo;
import lotto.domain.Prize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        buyer.buyLotto();
        assertThat(buyer.getAutoLottoCount()).isEqualTo(14);
    }

    @Test
    void checkWinLottoTest() {
        int bonusNumber = 6;
        List<Integer> numberList = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<LottoNo> winningNumberList = new ArrayList<>(List.of( new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        Lotto lotto = new Lotto(numberList.stream().map(integer -> new LottoNo(integer)).collect(Collectors.toList()));
        List<Lotto> lottoList = new ArrayList<>(List.of(lotto));
        Buyer winBuyer = new Buyer(0, 0, lottoList);
        Map<Prize, Integer> winningList = winBuyer.checkLotto(winningNumberList, new LottoNo(bonusNumber));
        assertThat(winningList.get(Prize.FIRST)).isEqualTo(1);
    }


}
