package lotto;

import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoComparatorTest {

    @Test
    public void 로또비교() {
        Set<Integer> lottoNumber = new TreeSet<>(Arrays.asList(5, 12, 25, 28, 33, 42));
        List<Lotto> purchasLottos = new ArrayList<>();
        purchasLottos.add(new Lotto(lottoNumber));

        LottoComparator lottoComparator = new LottoComparator();
        lottoComparator.comparate(purchasLottos,lottoNumber);

        Map<LottoType, Integer> winnings = lottoComparator.getWinnings();
        int result = winnings.get(LottoType.SIX);
        assertThat(result).isOne();
    }
}