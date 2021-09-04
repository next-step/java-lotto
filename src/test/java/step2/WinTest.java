package step2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class WinTest {
    @Test
    void countNumberOfMatchTest() {
        final LottoNumbers winningNumber = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 7, 8));
        int matchCount = winningNumber.countNumberOfMatch(lottoNumbers);
        int expected = 4;
        assertThat(matchCount).isEqualTo(expected);
    }

    @Test
    void matchSuccessTest1() {
        final List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        final Lottos wonLottos = new Lottos(Arrays.asList(
                new Lotto(lottoNumbers),
                new Lotto(lottoNumbers),
                new Lotto(lottoNumbers)));
        System.out.println(wonLottos);

        final WinningLotto standardLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        final Match actual = standardLotto.match(wonLottos);
        System.out.println(actual);

        final Match expected = createTestMatch(6, 3);
        System.out.println(expected);

        assertThat(actual).isEqualTo(expected);
    }

    private Match createTestMatch(int matchCount, int amount) {
        return new Match(createTestMatchValue(matchCount, amount),
                createTestProfitValue(matchCount, amount));
    }

    private Map<MatchNumber, Integer> createTestMatchValue(int matchCount, int amount) {
        Map<MatchNumber, Integer> match = new HashMap<>();
        match.put(MatchNumber.THREE, 0);
        match.put(MatchNumber.FOUR, 0);
        match.put(MatchNumber.FIVE, 0);
        match.put(MatchNumber.SIX, 0);
        final MatchNumber target = MatchNumber.createMatchNumber(matchCount);
        match.put(target, amount);
        return match;
    }

    private long createTestProfitValue(int matchCount, int amount) {
        final MatchNumber matchNumber = MatchNumber.createMatchNumber(matchCount);
        return matchNumber.winnings * amount;
    }

    @Test
    void matchSuccessTest2() {
        final List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);
        final Lottos wonLottos = new Lottos(Arrays.asList(new Lotto(lottoNumbers),
                new Lotto(lottoNumbers),
                new Lotto(lottoNumbers)));
        System.out.println(wonLottos);

        final WinningLotto standardLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Match actual = standardLotto.match(wonLottos);
        System.out.println(actual);

        final Match expected = createTestMatch(3, 3);
        System.out.println(expected);

        assertThat(actual).isEqualTo(expected);
    }
}
