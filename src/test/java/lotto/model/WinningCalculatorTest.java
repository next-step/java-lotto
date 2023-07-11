package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class WinningCalculatorTest {

    private Lotto createLotto(int... ints) {
        return new Lotto(Arrays.stream(ints)
                .boxed()
                .map(LottoNumber::new)
                .collect(toList()));
    }

    private List<Lotto> createLottos(Lotto... lottos) {
        return Arrays.stream(lottos)
                .collect(toList());
    }

    private List<LottoNumber> createLottoNumbers(int... ints) {
        return Arrays.stream(ints)
                .boxed()
                .map(LottoNumber::new)
                .collect(toList());
    }

    @Test
    @DisplayName("구매한 로또와 당첨 로또 비교")
    void 구매로또_당첨로또_비교() {
        WinningCalculator winningCalculator = new WinningCalculator();

        PurChasedLotto purChasedLotto = new PurChasedLotto(
                createLottos(
                        createLotto(1, 2, 3, 4, 5, 6),
                        createLotto(1, 2, 3, 4, 5, 6),
                        createLotto(1, 4, 6, 8, 10, 12)));
        WinningLotto winningLotto = new WinningLotto(
                createLottoNumbers(1, 2, 3, 4, 5, 6), 7);

        Map<Rank, Integer> result = winningCalculator.calculate(winningLotto, purChasedLotto);

        Assertions.assertThat(result.get(Rank.THREE)).isEqualTo(1);
        Assertions.assertThat(result.get(Rank.FOUR)).isEqualTo(0);
        Assertions.assertThat(result.get(Rank.FIVE)).isEqualTo(0);
        Assertions.assertThat(result.get(Rank.FIVE_WITH_BONUS)).isEqualTo(0);
        Assertions.assertThat(result.get(Rank.SIX)).isEqualTo(2);
    }


}
