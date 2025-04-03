import Lotto.domain.LottoList;
import Lotto.domain.LottoNumber;
import Lotto.domain.Lotto;
import Lotto.service.LottoGame;


import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoGameTest {
    @Test
    void calculateProfitRate_ShouldReturnCorrectRate() {
        LottoList lottoList = new LottoList();
        lottoList.addLotto(new Lotto(List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(7), new LottoNumber(8), new LottoNumber(9))));
        Set<LottoNumber> winningNumbers = Set.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        double profitRate = LottoGame.calculateProfitRate(lottoList, winningNumbers);
        assertEquals(5000.0 / 1000, profitRate, 0.01);
    }
}
