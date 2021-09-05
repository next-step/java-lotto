package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.utils.MatchTestUtil;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    @DisplayName("3등(4개 일치) 확인 테스트 ")
    void countNumberOfMatchTest() {
        final LottoNumbers winningNumber = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        final LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 7, 8));
        int matchCount = winningNumber.countNumberOfMatch(lottoNumbers);
        int expected = 4;
        assertThat(matchCount).isEqualTo(expected);
    }

    @Test
    @DisplayName("1등(6개 일치), 3개 구매에 대한 통계 테스트")
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

        final Match expected = MatchTestUtil.createTestMatch(6, 3);
        System.out.println(expected);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("5등(3개 일치), 3개 구매에 대한 통계 테스트")
    void matchSuccessTest2() {
        final List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 10, 11, 12);
        final Lottos wonLottos = new Lottos(Arrays.asList(new Lotto(lottoNumbers),
                new Lotto(lottoNumbers),
                new Lotto(lottoNumbers)));
        System.out.println(wonLottos);

        final WinningLotto standardLotto = new WinningLotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Match actual = standardLotto.match(wonLottos);
        System.out.println(actual);

        final Match expected = MatchTestUtil.createTestMatch(3, 3);
        System.out.println(expected);

        assertThat(actual).isEqualTo(expected);
    }
}
