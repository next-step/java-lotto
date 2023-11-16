package lotto;

import lotto.domain.Buyer;
import lotto.domain.Rank;
import lotto.domain.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class BuyerTest {
    @Test
    void 구매금액에맞게_로또가_구입되는지확인() {
        int money = 15500;
        Buyer buyer = new Buyer();
        buyer.purchaseLotto(money);
        assertThat(Buyer.purchasedLottoNumbers.size()).isEqualTo(15);
    }

    @Test
    void 당첨된결과가_정확한지테스트() {
        List<Integer> purchasedNumber = List.of(1,2,3,4,5,6);
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,7,8");
        Buyer buyer = new Buyer();

        Buyer.purchasedLottoNumbers.add(purchasedNumber);
        buyer.checkLottoWinningNumbers(buyer,winningNumbers);

        HashMap<Rank,Integer> result = Buyer.lottoResult;

        assertThat(result.get(Rank.Four)).isEqualTo(1);
    }
}
