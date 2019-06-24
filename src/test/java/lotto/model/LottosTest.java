package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class LottosTest {

    @Test
    @DisplayName("로또 맞춰보기")
    public void checkLotts() {

        List<PickNumbers> lottoNumbers = Arrays.asList(
                new PickNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new PickNumbers(Arrays.asList(2, 3, 4, 5, 6, 7)),
                new PickNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new PickNumbers(Arrays.asList(10, 11, 12, 13, 14, 15)),
                new PickNumbers(Arrays.asList(4, 5, 6, 7, 8, 9))
        );
        Lottos lottos = new Lottos(lottoNumbers);
        PickNumbers winnerNumbers = new PickNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));

        Map<Integer, Integer> aggregate = lottos.aggregate(winnerNumbers);
        System.out.println(aggregate);
    }
}
