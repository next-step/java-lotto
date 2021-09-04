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
    void matchSuccessTest1() {
        final List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final Lottos winningLottos = new Lottos(Arrays.asList(new Lotto(lottoNumbers),
                new Lotto(lottoNumbers),
                new Lotto(lottoNumbers)));

        final WinningLotto standardLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Match match = standardLotto.match(winningLottos);
        System.out.println(winningLottos);
        System.out.println(match);

        assertThat(match.getMatchCount(MatchNumber.SIX)).isEqualTo(winningLottos.count());
    }

    @Test
    void matchSuccessTest2() {
        final List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);
        final Lottos winningLottos = new Lottos(Arrays.asList(new Lotto(lottoNumbers),
                new Lotto(lottoNumbers),
                new Lotto(lottoNumbers)));

        final WinningLotto standardLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Match match = standardLotto.match(winningLottos);
        System.out.println(winningLottos);
        System.out.println(match);

        assertThat(match.getMatchCount(MatchNumber.THREE)).isEqualTo(winningLottos.count());
    }

    @Test
    void matchAddSuccessTest() {
        Match match = new Match();
        match.add(3);

        final int actual = match.getMatchCount(MatchNumber.THREE);
        final int expected = 1;
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void matchAddFailTest() {
        Match match = new Match();
        match.add(1);

        System.out.println(match);
    }
}
