package lotto;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningNumberTest {

    @Test
    public void 로또비교() {
        Set<Integer> lottoNumber = new TreeSet<>(Arrays.asList(5, 12, 25, 28, 33, 42));
        List<Lotto> purchasLottos = new ArrayList<>();
        purchasLottos.add(new Lotto(lottoNumber));
        WinningNumber winningNumber = new WinningNumber("5, 12, 25, 20, 30, 40");

        Map<LottoType, Integer> winnings = winningNumber.match(purchasLottos);
        int result = winnings.get(LottoType.THREE);

        assertThat(result).isOne();
    }
}