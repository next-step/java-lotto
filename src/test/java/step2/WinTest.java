package step2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinTest {
    @Test
    void countNumberOfMatchTest() {
        final LottoNumbers winningNumber = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 4, 4));
        int matchCount = winningNumber.countNumberOfMatch(lottoNumbers);
        int expected = 4;
        assertThat(matchCount).isEqualTo(expected);
    }

    @Test
    void test() {
        final List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final Lottos winningLottos = new Lottos(Arrays.asList(new Lotto(lottoNumbers),
                new Lotto(lottoNumbers),
                new Lotto(lottoNumbers)));

        final WinningLotto standardLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Match match = standardLotto.match(winningLottos);
        System.out.println(winningLottos);
        System.out.println(match);

        assertThat(match.sixMatch()).isEqualTo(winningLottos.count());
    }
}
