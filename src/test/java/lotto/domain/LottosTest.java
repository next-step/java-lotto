package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {
    @DisplayName("각 로또의 결과를 RANK와 해당 RANK의 개수로 저장한다")
    @Test
    void 결과가_1등_1개_2등_1개_3등_2개인_경우() {
        List<Integer> testNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto testLotto = Lotto.fromNumbers(testNumbers);
        LottoNumber bonus = LottoNumber.from(7);
        WinningLotto testWinningLotto = new WinningLotto(testLotto, bonus);

        List<Integer> first = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> second = Arrays.asList(1, 2, 3, 4, 5, 7);
        List<Integer> third1 = Arrays.asList(11, 2, 3, 4, 5, 6);
        List<Integer> third2 = Arrays.asList(1, 2, 3, 41, 5, 6);

        List<Lotto> lottos = Arrays.asList(
            Lotto.fromNumbers(first),
            Lotto.fromNumbers(second),
            Lotto.fromNumbers(third1),
            Lotto.fromNumbers(third2)
        );

        Lottos testLottos = Lottos.withListLotto(lottos);

        Map<Rank, Integer> actual = testLottos.mapResult(testWinningLotto);
        assertThat(actual.get(Rank.FIRST)).isEqualTo(1);
        assertThat(actual.get(Rank.SECOND)).isEqualTo(1);
        assertThat(actual.get(Rank.THIRD)).isEqualTo(2);
        assertThat(actual.get(Rank.FOURTH)).isEqualTo(0);
        assertThat(actual.get(Rank.FIFTH)).isEqualTo(0);
    }
}
