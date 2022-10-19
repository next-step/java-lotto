package lotto;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningCalculatorTest {
    private List<Integer> numbers(int min, int max) {
        return IntStream.range(min, max).boxed().collect(Collectors.toList());
    }

    @Test
    void 생성() {
        Lotto winner = new Lotto(numbers(1, 7));
        List<Lotto> myLotto = new ArrayList<>();
        myLotto.add(new Lotto(numbers(1, 7)));
        assertThat(new LottoWinningCalculator(winner, myLotto)).isEqualTo(new LottoWinningCalculator(winner, myLotto));
    }

    @Test
    void 당첨번호_일치하는_로또_계산() {
        Lotto winner = new Lotto(numbers(1, 7));
        List<Lotto> myLotto = new ArrayList<>();
        myLotto.add(new Lotto(numbers(1, 7)));
        myLotto.add(new Lotto(numbers(4, 10)));

        HashMap<Integer, Integer> prizeMap = new HashMap<>();
        prizeMap.put(3, 1);
        prizeMap.put(4, 0);
        prizeMap.put(5, 0);
        prizeMap.put(6, 1);
        assertThat(new LottoWinningCalculator(winner, myLotto).countPrizeMap()).isEqualTo(prizeMap);
    }
}
