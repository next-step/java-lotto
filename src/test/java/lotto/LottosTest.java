package lotto;

import lotto.model.LottoNumbers;
import lotto.model.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottosTest {

    @Test
    @DisplayName("로또 맞춰보기")
    public void checkLotts() {

        List<LottoNumbers> lottoNumbers = Arrays.asList(
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(2, 3, 4, 5, 6, 7)),
                new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LottoNumbers(Arrays.asList(10, 11, 12, 13, 14, 15)),
                new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9))
        );
        Lottos lottos = new Lottos(lottoNumbers);
        LottoNumbers winnerNumbers = new LottoNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));

        Map<Integer, Integer> aggregate = lottos.aggregate(winnerNumbers);
        System.out.println(aggregate);
    }
}
